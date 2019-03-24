package threads_learning.ThreadWays;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello ! I am from call String . . ...";
    }

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 启动线程
        Future<String> future = threadPool.submit(new MyThread3());
        try
        {
            System.out.println("waiting thread to finish.");
            System.out.println(future.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
