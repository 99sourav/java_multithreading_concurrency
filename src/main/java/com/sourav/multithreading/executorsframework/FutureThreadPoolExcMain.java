package com.sourav.multithreading.executorsframework;

import java.util.concurrent.*;

public class FutureThreadPoolExcMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,2,TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);
        Future<?> futureObj = executor.submit(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException " + e);
            }
            System.out.println("Task processing " + Thread.currentThread().getName());
        });
        // caller(main thread) is checking the status of the new thread created.
        System.out.println("Task Completed " + futureObj.isDone());
        executor.shutdown();
        try {
            futureObj.get(3000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println("TimeoutException " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e.getMessage());
        }
        try {
            futureObj.get();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e.getMessage());
        }
        System.out.println("Task Completed " + futureObj.isDone());
        System.out.println("is Cancelled " + futureObj.isCancelled());
        System.out.println(Thread.currentThread().getName() + " Thread finished");
    }
}
