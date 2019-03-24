package threads_learning.ThreadWays;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable's run is running ~ ");
    }

    public static void main(String[] args){
        MyThread2 thread2 = new MyThread2();
        Thread t = new Thread(thread2);
        t.start();
    }
}
