package com.sourav.multithreading.executorsframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,2, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);
        CompletableFuture<List<Integer>> asyncTaskObj = CompletableFuture.supplyAsync(()->{
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                integerList.add(i);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Error :{} " + e.getMessage());
            }
            System.out.println("Task processing " + Thread.currentThread().getName());
            return integerList;
        }, executor);
        try {
            System.out.println("result " + asyncTaskObj.get());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e.getMessage());
        }
    }
}
