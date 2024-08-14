package com.sourav.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMain {
    public static void main(String[] args) {
        int numberOfServices = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        executorService.submit(new RunnableTask1(countDownLatch));
        executorService.submit(new RunnableTask2(countDownLatch));
        executorService.submit(new RunnableTask3(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " Thread Finished");
    }
}

class RunnableTask1 implements Runnable{
    private final CountDownLatch countDownLatch;

    public RunnableTask1(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}

class RunnableTask2 implements Runnable{
    private final CountDownLatch countDownLatch;

    public RunnableTask2(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}

class RunnableTask3 implements Runnable{
    private final CountDownLatch countDownLatch;

    public RunnableTask3(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}