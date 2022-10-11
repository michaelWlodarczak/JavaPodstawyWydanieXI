package rozdzial11.synch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Bank z kilkoma kontami, kontrolujacy dostep za pomoca blokad.
 */
public class BankSynch {

    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFounds;

    /*
    Tworzy bank.
    @param n liczba kont
    @param initialBalance poczatkowe saldo kazdego konta
     */
    public BankSynch(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFounds = bankLock.newCondition();
    }

    /*
    Przelewa pieniadze pomiedzy kontami
    @param from konto z ktorego ma nastapic przelew
    @param to konto docelowe
    @param amount kwota przelewu
     */
    public void transfer(int from, int to, double amount) throws InterruptedException{
        bankLock.lock();
        try{
            while (accounts[from]<amount)
                sufficientFounds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -=amount;
            System.out.printf(" %10.2f z %d na %d", amount, from, to);
            accounts[to] +=amount;
            System.out.printf(" Saldo ogolne: %10.2f%n", getTotalBalance());
            sufficientFounds.signalAll();
        }
        finally {
            bankLock.unlock();
        }
    }

    /*
    Oblicza sume wszystkich sald kont.
    @return saldo ogolne
     */
    public double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    /*
    Sprawdza liczbe kont w banku
    @return liczba kont
     */
    public int size(){
        return accounts.length;
    }

}
