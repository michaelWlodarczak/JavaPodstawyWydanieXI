package rozdzial9.conversion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
Conversion between collections and arrays
 */
public class Conversion {
    public static void main(String[] args) {

        String[] values = {"Hanna","Michal","Krzysztof","Anna","Krystian","Martyna","Adam"};

        var names = new HashSet<>(List.of(values));
        System.out.println(names);

        System.out.println(values); //niejawne wywolanie metody

        for (int i = 0; i < values.length; i++) { //iteracja po elementach
            System.out.println(values[i]);
        }

        System.out.println(Arrays.deepToString(values)); //metoda ta jako parametr przyjmuje tablicę obiektów.
        // Dzięki czemu można wydrukować wszystkie obiekty wraz z ich zwartością

        System.out.println(line());


    }
    static String line(){
        return "====================";
    }
}
