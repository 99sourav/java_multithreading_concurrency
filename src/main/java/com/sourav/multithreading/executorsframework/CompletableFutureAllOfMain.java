package com.sourav.multithreading.executorsframework;

import java.util.concurrent.*;

public class CompletableFutureAllOfMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
                System.out.println("Task processed successfully " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("failed :{} " + e);
            }
            return "success for " + Thread.currentThread().getName();
        }, executor);
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
                System.out.println("Task processed successfully " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("failed :{} " + e);
            }
            return "success for " + Thread.currentThread().getName();
        }, executor);
        executor.shutdown();
        CompletableFuture<Void> targetFuture = CompletableFuture.allOf(f1, f2);
        targetFuture.join();
        System.out.println(Thread.currentThread().getName() + " Thread finished ");
    }
}
