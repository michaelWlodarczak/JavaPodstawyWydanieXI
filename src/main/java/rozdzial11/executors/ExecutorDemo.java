package rozdzial11.executors;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Program demonstrujacy interfejs Callable i egzekutory
 */
public class ExecutorDemo {

    /*
    Liczy wystapienia danego slowa w pliku
    @return liczba wystapien danego slowa
     */
    public static long occurrences(String word, Path path) {
        try (var in = new Scanner(path)) {
            int count = 0;
            while (in.hasNext())
                if (in.next().equals(word)) count++;
        } catch (IOException e) {
        }
        return 0;
    }

    /*
    Zwraca wszystkie podkatalogi danego katalogu
    @param rootDir katalog glowny
    @return zbior wszystkich podkatalogow katalogu glownego
     */
    public static Set<Path> descendants(Path rootDir) throws IOException {
        try (Stream<Path> entries = Files.walk(rootDir)) {
            return entries.filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        }
    }

    /*
    Tworzy zadanie szukajace slowa w pliku
    @param word szukane slowo
    @param path plik do przeszukania
    @return zadanie wyszukiwania, ktore zwraca sciezke w przypadku powodzenia
     */
    public static Callable<Path> searchForTask(String word, Path path) {
        return () -> {
            try (var in = new Scanner(path)) {
                while (in.hasNext()) {
                    if (in.next().equals(word)) return path;
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Szukanie w " + path + " anulowano.");
                    }
                }
                throw new NoSuchFieldException();
            }
        };
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException, IOException {

        try (var in = new Scanner(System.in)) {
            System.out.println("Wpisz sciezke katalogu podstawowego (np. /opt/jdk-9-src): ");
            String start = in.nextLine();
            System.out.println("Wpisz slowo kluczowe (np. volatile): ");
            String word = in.nextLine();

            Set<Path> files = descendants(Path.of(start));
            var tasks = new ArrayList<Callable<Long>>();
            for (Path file : files) {
                Callable<Long> task = () -> occurrences(word, file);
                tasks.add(task);
            }
            ExecutorService executor = Executors.newCachedThreadPool();
            //uzyj egzekutora watku, aby sprawdzic, czy
            //wieksza liczba watkow przyspiesza wyszukiwanie
            //ExecutorService executor = Executors.newSingleThreadExecutor();

            Instant startTime = Instant.now();
            List<Future<Long>> results = executor.invokeAll(tasks);
            long total = 0;
            for (Future<Long> result : results)
                total += result.get();
            Instant endTime = Instant.now();
            System.out.println("Liczba wystapien slowa " + word + ": " + total);
            System.out.println("Czas: "
                    + Duration.between(startTime, endTime).toMillis() + " ms");

            var searchTasks = new ArrayList<Callable<Path>>();
            for (Path file : files)
                searchTasks.add(searchForTask(word, file));
            Path found = executor.invokeAny(searchTasks);
            System.out.println(word + " wystepuje w: " + found);

            if (executor instanceof ThreadPoolExecutor) //egzekutor jednowatkowy nie jest
                System.out.println("Najwiekszy rozmiar puli: " +
                        ((ThreadPoolExecutor) executor).getLargestPoolSize());
            executor.shutdown();

        }
    }
}
