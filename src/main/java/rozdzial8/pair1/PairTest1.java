package rozdzial8.pair1;

import java.util.Arrays;

public class PairTest1 {
    public static void main(String[] args) {

        String [] words = {"o","jade","kotwica","dom"};
        Pair<String> mm = ArrayAlg.minmax(words);

        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

    }
}
