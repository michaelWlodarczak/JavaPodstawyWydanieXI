package rozdzial8.pair1;

//TODO - ZDECYDOWANIE DO TEGO WROCIC!!! COS JEST MEGA NIE TAK Z TA METODA!!!

public class ArrayAlg {

    /*Pobiera najmniejsza i najwieksza wartosc z tablicy lancuchowej
    'a' - tablica lancuchow
    return - zlozona z najmniejszej i najwiekszej wartosic lub null, jesli tablica 'a' jest null badz pusta
    */

    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];

        for (int i = 0; i < a.length; i++) {
            if(min.compareTo(a[i])>0)min=a[i];
            if (max.compareTo(a[i])<0)max=a[i];
//            if (a[i].length()<min.length()) min=a[i];
//            if (a[i].length()>max.length()) max=a[i];
        }
        return new Pair<>(min, max);
    }
}

