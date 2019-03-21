package threads.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance){
        this.accounts = new double[n];
        for (int i=0;i< accounts.length;i++ ){
            accounts[i] = initialBalance;
        }
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from,int to,double amount)throws InterruptedException{
        bankLock.lock();
        try {
            while (accounts[from]< amount)
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
            sufficientFunds.signalAll();
        }finally {
            bankLock.unlock();
        }

    }

    public double getTotalBalance(){
        bankLock.unlock();
        try {
            double sum = 0;

            for (double a : accounts){
                sum += a;
            }
            return sum;
        }finally {
            bankLock.unlock();
        }
    }

    public int size(){
        return accounts.length;
    }
    /*
    * 使用synchronize关键字，来调用内部对象锁
    * */
    public synchronized void transfer(int form, int to, int amount) throws InterruptedException{
        while (accounts[form] > amount)
            wait();
        accounts[form] -= amount;
        accounts[to] += amount;
        notifyAll();
    }
}
