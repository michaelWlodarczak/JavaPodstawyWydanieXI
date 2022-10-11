package rozdzial11.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class BankWithLock {

    private final double[] accounts;
    private ReentrantLock bankLock = new ReentrantLock(); //klasa ReentrantLock ()
                                                            // implementujaca interfejs Lock


    public BankWithLock(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    //metoda transfer ochroniona za pomoca blokady
    public void transfer(int from, int to, double amount){
        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f z %d na %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf(" Saldo ogolne: %10.2f%n", getTotalBalance());
        }
        finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        double sum = 0;
        for (double a : accounts)
            sum += a;

        return sum;
    }

    public int size(){
        return accounts.length;
    }

}
