package rozdzial11.threads;

import java.util.*;

/*
Bank z pewna liczba kont.
 */
public class Bank {

    private final double[] accounts;

    /*
    Tworzy bank.
    @param n liczba kont
    @param initialBalance poczatkowe saldo kazdego konta
     */
    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    /*
    Przelewa pieniadze z jednego konta na inne
    @param from konto zrodlowe
    @param to konto docelowe
    @param amount kwota przelewu
     */
    public void transfer(int from, int to, double amount){
        if (accounts[from]<amount) return;
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f z %d na %d",amount,from,to);
        accounts[to] += amount;
        System.out.printf(" Saldo calkowite: %10.2f%n", getTotalBalance());
    }

    /*
    Oblicza sume wszystkich sald kont.
    @return saldo calkowite
     */
    public double getTotalBalance(){
        double sum = 0;
        for (double a : accounts)
            sum += a;

        return sum;
    }

    /*
    Sprawdza liczbe kont w banku
    @return liczba kont
     */
    public int size(){
        return accounts.length;
    }

}
