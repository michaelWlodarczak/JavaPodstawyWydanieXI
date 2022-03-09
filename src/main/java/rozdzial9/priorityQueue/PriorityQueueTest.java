package rozdzial9.priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.out.println("Iteracja przez elementy: ");
        for (LocalDate date : pq)
            System.out.println(date);
        System.out.println("Usuwanie elementow: ");
        while (pq.isEmpty()) //while (!pq.isEmpty()) <- tak bylo w ksiazce st.464
            System.out.println(pq.remove());
    }
}
