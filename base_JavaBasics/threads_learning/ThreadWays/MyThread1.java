package threads_learning.ThreadWays;

public class MyThread1 extends Thread {
    // 创建线程类
    public void run(){
        System.out.println("Thread body");
    }

    public static void main(String[] args){
        MyThread1 thread = new MyThread1();
        thread.start();
    }
}
