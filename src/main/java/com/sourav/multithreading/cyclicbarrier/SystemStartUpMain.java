package com.sourav.multithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SystemStartUpMain {
    public static void main(String[] args) {
        int numberOfSubSystem = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfSubSystem);
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubSystem, ()->{
            System.out.println("All systems are up and running .....");
        });
        executorService.submit(new SubSystem("webservice", 2000, barrier));
        executorService.submit(new SubSystem("database", 1000, barrier));
        executorService.submit(new SubSystem("redis-service", 2000, barrier));
        executorService.submit(new SubSystem("messaging-service", 2000, barrier));
        executorService.shutdown();
    }
}

class SubSystem implements Runnable{
    private final String nameOfSystem;
    private final long initializationTime;
    private final CyclicBarrier cyclicBarrier;

    SubSystem(String nameOfSystem, long initializationTime, CyclicBarrier cyclicBarrier) {
        this.nameOfSystem = nameOfSystem;
        this.initializationTime = initializationTime;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(nameOfSystem + " initialization started");
        try {
            Thread.sleep(initializationTime); // average time taken for initialize
        } catch (InterruptedException e) {
            System.out.println("error to block the current thread for specific time " + e.getMessage());
        }
        System.out.println(nameOfSystem + " initialization completed");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
    }
}
