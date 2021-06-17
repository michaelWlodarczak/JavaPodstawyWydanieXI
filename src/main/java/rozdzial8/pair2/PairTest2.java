package rozdzial8.pair2;

import java.time.LocalDate;

public class PairTest2 {
    public static void main(String[] args) {

        LocalDate[] birthdays=
                {
                        LocalDate.of(1906,12,9),
                        LocalDate.of(1815,12,10),
                        LocalDate.of(1903,12,3),
                        LocalDate.of(1910,6,22),
                        LocalDate.of(2019,10,14),
                        LocalDate.of(1987,12,15)
                };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());
    }
}
