package rozdzial9.set;

//TODO - WROCIC DO TEGO , TOTALNIE NIE ROZUMIEM ZASTOSOWANIA PROGRAMU


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SetTest {
    public static void main(String[] args) {
        var words = new HashSet<String>();
        long totalTime = 0;

        try (var in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime; // totalTime = totalTime + callTime;
            }
        }
        Iterator<String> iterator = words.iterator();
        for (int i = 1; i <= 10 && iterator.hasNext(); i++) {
            System.out.println(iterator.next());
            System.out.println(". . .");
            System.out.println(words.size() + " niepowtarzajacych sie slow. " + totalTime + " milisekund.");
        }
    }
}
