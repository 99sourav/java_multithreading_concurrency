package com.sourav.multithreading.executorsframework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//      Thread[] threadArr = new Thread[10];
        ExecutorService executorService = Executors.newFixedThreadPool(6); // ThreadPoolExecutor
        for (int i = 0; i < 10; i++) {
            int finalI = i;
                executorService.submit(()->{
                    System.out.println("factorial of " + finalI + " " + factorial(finalI));
                });
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(50, TimeUnit.SECONDS)){
                System.out.println("Timeout occurred before termination. Forcing shutdown.");
                executorService.shutdownNow(); // Forcefully shutdown if not terminated
            } else {
                System.out.println("All tasks completed within the timeout.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("total time " + (System.currentTimeMillis()-startTime));
    }
    private static int factorial(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (i==0){
            return 1;
        }
        int fact = 1;
        for (int j = i; j > 0; j--) {
            fact = fact*j;
        }
        return fact;
    }
}
