package rozdzial11.synch2;

import java.util.Arrays;

/*
Bank z kilkoma kontami, wykorzystujacy synchronizacje
 */
public class BankSynch2 {

    private final double[] accounts;

    /*
    Tworzy bank.
    @param n liczba kont
    @param initialBalance poczatkowe saldo kazdego konta
     */
    public BankSynch2(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /*
    Przelewa pieniadze pomiedzy kontami
    @param from konto z ktorego ma nastapic przelew
    @param to konto docelowe
    @param amount kwota przelewu
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount)
            wait();
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f z %d na %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Saldo ogolne: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    /*
    Oblicza sume wszystkich sald kont.
    @return saldo ogolne
     */
    public synchronized double getTotalBalance() {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
    }

    /*
    Sprawdza liczbe kont w banku
    @return liczba kont
     */
    public int size() {
        return accounts.length;
    }

}
