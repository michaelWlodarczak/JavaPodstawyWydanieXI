package rozdzial9.simpleAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SimpleAlgorithms {
    public static void main(String[] args) {

        var words = new ArrayList<String>();

        words.add("Java");
        words.add("SQL");
        words.add("C++");
        words.add("Python");
        words.add("HTML");

        System.out.println("SIMPLE ALGORITHMS:\n");
        System.out.println("Original list " + words);

//        for (int i = 0; i < words.size(); i++) {
//            if(words.get(i).equals("C++"))words.set(i,"Java");
//        }

        Collections.replaceAll(words,"C++","Java");
        System.out.println("List after replacement, by using standard method from library " + words);

        words.removeIf(w -> w.length()<=3);
        System.out.println("List after removing words with lenght smaller than three: " + words);

        words.replaceAll(String::toLowerCase);
        System.out.println("List to lower case: " + words);

        System.out.println(line());
        System.out.println("COLLECTIVE OPERATIONS:\n");

        HashSet<String> firstSet = new HashSet<>();
        firstSet.add("Hanna");
        firstSet.add("Michal");
        firstSet.add("Krzysztof");
        firstSet.add("Jozef");
        var secondSet = new HashSet<String>();
        secondSet.add("Hanna");
        secondSet.add("Michal");
        secondSet.add("Krzysztof");
        secondSet.add("Bogusia");
        var result = new HashSet<String>(firstSet);

        System.out.println("First set: " + firstSet);
        System.out.println("Second set: " + secondSet);

        firstSet.removeAll(secondSet);
        System.out.println("Firs set after removing second set: " + firstSet);
        result.retainAll(secondSet);

        System.out.println("RetainAll method in result set means its only \n" +
                "common elements from first and second set: " + result);

    }

    public static String line(){
        return "--------------------------------";
    }
}
