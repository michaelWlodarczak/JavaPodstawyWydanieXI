package rozdzial7.stackTrace;

public class Rekurencja {

    public int sumaIteracja(int n){
        int suma = 0;
        while (n>0){
            suma=suma+n;
            n--;
        }
        return suma;
    }

    public int sumaRekurencja(int n){
        if(n>0){
            return n+sumaRekurencja(n-1);
        }else {
            return 0;
        }
    }
    //ta sama metoda wykozystujaca operator trojargumentowy (ternary operator)
    public int sumaRekurencja2(int n){
        return n>0? n+sumaRekurencja2(n-1) : 0;
    }

    /*
    W przypadku wersji rekurencyjnej, sprawdzamy, czy parametr jest wiekszy od '0', jesli tak to zwracamy sume
    tej liczby 'i' wraz z wywolaniem tej funkcji z parametrem o 1 mniejszym.
    Jesli parametr jest mniejszy lub rowny 0 to zwracamy 0

    Wazne jest tutaj, ze sumaRekurencja(2) nie ma pojecia o tym, ze jest skladnikiem sumy w sumaRekurencja(3)
    Elementy sa odkladane na stosie, a nastepnie zbierane od konca. Tak na prawde nie dodajemy 3+2+1+0, tylko,
    0+1+2+3.
     */

    public static void main(String[] args) {
        Rekurencja r = new Rekurencja();
        int iteracja, rekurencja, rekurencja2 = 0;

        iteracja = r.sumaIteracja(3);
        rekurencja = r.sumaRekurencja(3);
        rekurencja2 = r.sumaRekurencja2(3);

        System.out.println("Iteracja " + iteracja);
        System.out.println("Rekurencja " + rekurencja);
        System.out.println("Rekurencja2 " + rekurencja2);
    }
}
