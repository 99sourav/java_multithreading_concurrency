package com.sourav.multithreading.executorsframework;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThWithFixedDelayMain {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Future<?> futureSchObj = scheduledExecutorService.scheduleWithFixedDelay(()->{
            System.out.println("Task is picked by scheduler thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task scheduled at " + LocalTime.now());
        }, 1, 3, TimeUnit.SECONDS);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            System.out.println("error to execute " + e.getMessage());
        }
        futureSchObj.cancel(true);
        scheduledExecutorService.shutdown();
    }
}
