package com.sourav.multithreading.executorsframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CompleteFutureThenApplyMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,2, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);
        CompletableFuture<List<Integer>> asyncTaskObj = CompletableFuture.supplyAsync(()->{
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                integerList.add(i);
            }
            try {
                System.out.println("Thread name of supply async " + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException " + e);
            }
            System.out.println("Task processing " + Thread.currentThread().getName());
            return integerList;
        }, executor).thenApply((integerList)->{
            // functionality which can work on the result of previous async task
            System.out.println("Thread name of then apply " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                integerList.set(i, random.nextInt());
            }
            return integerList;
        });
        executor.shutdown();
        try {
            System.out.println("result " + asyncTaskObj.get());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
    }
}
