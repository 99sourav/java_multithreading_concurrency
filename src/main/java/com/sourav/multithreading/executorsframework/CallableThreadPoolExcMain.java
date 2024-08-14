package com.sourav.multithreading.executorsframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableThreadPoolExcMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,2, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executor.allowCoreThreadTimeOut(true);
        Future<List<Integer>> callableObj = executor.submit(()->{
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                integerList.add(i);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException " + e);
            }
            System.out.println("Task processing " + Thread.currentThread().getName());
            return integerList;
        });
        // caller(main thread) is checking the status of the new thread created.
        System.out.println("Task Completed " + callableObj.isDone());
        executor.shutdown();
        try {
            callableObj.get(3000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println("TimeoutException " + e);
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
        try {
            List<Integer> result = callableObj.get();
            System.out.println("result " + Arrays.asList(result).get(0));
        } catch (ExecutionException e) {
            System.out.println("ExecutionException " + e);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
        System.out.println("Task Completed " + callableObj.isDone());
        System.out.println("is Cancelled " + callableObj.isCancelled());
        System.out.println(Thread.currentThread().getName() + " Thread finished");
    }
}
