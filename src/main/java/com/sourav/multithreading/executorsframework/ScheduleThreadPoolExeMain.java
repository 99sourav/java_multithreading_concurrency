package com.sourav.multithreading.executorsframework;

import java.util.concurrent.*;

public class ScheduleThreadPoolExeMain {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Future<String> stringFuture = scheduledExecutorService.schedule(()->{
            System.out.println("schedule Task processed by " + Thread.currentThread().getName());
            return "schedule Task1 processed successfully";
        }, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        try {
            System.out.println(stringFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("exception occurred " + e);
        }
    }
}
