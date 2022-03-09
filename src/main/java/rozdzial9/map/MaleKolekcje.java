package rozdzial9.map;

/*
Widoki i opakowania s. 476
 */

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaleKolekcje {
    public static void main(String[] args) {
        List<String> names = List.of("Krzys","Hania","Michal");
        Set<Integer> numbers = Set.of(14,19,15);
        System.out.println(names);
        System.out.println(numbers);

        Map<String,Integer>scores = Map.of("Krzys",14,"Hania",19,"Michal",15);
        System.out.println(scores);

        Map<List<String>,Set<Integer>> scores2 = Map.of(names,numbers);
        System.out.println(scores2);

        Map<String,Integer> scores3 = Map.ofEntries(Map.entry("Krzys",14),Map.entry("Hania",19),Map.entry("Michal",15));
        System.out.println(scores3);

        //Ponizsza instrukca tworzy ;iste zawierajaca 100 lancuchow "KRZYS"
        List<String>settings = Collections.nCopies(100,"KRZYS");
        System.out.println(settings);
    }
}
