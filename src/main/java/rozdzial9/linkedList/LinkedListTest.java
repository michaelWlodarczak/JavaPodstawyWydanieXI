package rozdzial9.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        var a = new LinkedList<String>();
        a.add("Hania");
        a.add("Michal");
        a.add("Krzys");

        var b = new LinkedList<String>();
        b.add("Anna");
        b.add("Krystian");
        b.add("Martyna");
        b.add("Adam");

        System.out.println("Lista a: \n" + a);
        System.out.println("Lista b: \n" + b);

        //scalanie list a i b
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println("Scalona lista a z b: \n" + a);

        //Usuniecie co drugiego slowa z listy b
        bIter = b.iterator();
        while (bIter.hasNext()) {
           bIter.next(); // Opuszczenie jednego elementu
            if (bIter.hasNext()){
                bIter.next(); // Opuszczenie nastepnego elementu
                bIter.remove(); //Usuniecie elementu
            }
        }
        System.out.println("Usuniecie co drugiego slowa z listy b: \n" + b);

        a.addFirst("Beata"); // Dodaje element na poczatku listy
        System.out.println("Dodanie elementu na poczatku listy a: \n" + a);
        a.addLast("Sebix"); // Dodaje element na koncu listy
        System.out.println("Dodanie elementu na koncu listy a: \n" + a);
        System.out.println("Zwracanie elemntu z poczatku listy:\n" + a.getFirst()); // Zwraca element z poczatku listy
        System.out.println("Zwracanie elementu z konca listy:\n" + a.getLast());  // Zwraca element z konca listy
        System.out.println("Usuwanie elementow z poczatku listy i konca listy,\n" +
                "w konsoli drukowany jest usuwany element, a nie lista bez elementu:");
        System.out.println(a.removeFirst()); // Usuwa element z poczatku listy, w konsoli drukowany jest usuwany element, a nie lista bez elementu
        System.out.println(a.removeLast()); // Usuwa element z konca listy
        System.out.println("Jeszcze raz lista a:\n" + a);

    }

}
