package rozdzial11.concurrentHashMap;

/*
Program liczy slowa w plikach Javy znajdujacych sie w drzewie katalogow przy uzyciu wspolbieznego slownika srotow
 */
/*
Program demonstrujacy uzycie slownikow skrotow
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CHMDemo {

    public static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
    /*
     Dodaje wszystkie slowa z pliku do wspolbieznego slownika skrotow
    */

    public static void process(Path file){
        try (var in = new Scanner(file)){
            while (in.hasNext()){
                String word = in.next();
                map.merge(word, 1L, Long::sum);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    Zwraca wszystkie podkatalogi danego katalogu
    @param rootDir katalog glowny
    @return zbior wszystkich podkatalogow katalogu glownego
     */
    public static Set<Path> descendants(Path rootDir) throws IOException{
        try (Stream<Path> entries = Files.walk(rootDir)){
            return entries.collect(Collectors.toSet());
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

        int processor = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(processor);
        Path pathToRoot = Path.of(".");
        for (Path p : descendants(pathToRoot)){
            if (p.getFileName().toString().endsWith(".java"))
                executor.execute(()->process(p));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        map.forEach((k,v)->{
            if(v>=10)
                System.out.println(k + " occurs " + v + " times ");
        });
    }
}
