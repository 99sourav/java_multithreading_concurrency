package com.sourav.multithreading.cyclicbarrier;

import com.sourav.multithreading.cyclicbarrier.RunnableTask1;
import com.sourav.multithreading.cyclicbarrier.RunnableTask2;
import com.sourav.multithreading.cyclicbarrier.RunnableTask3;

import java.util.concurrent.*;

public class CyclicBarrierMain {
    public static void main(String[] args) {
        int numberOfServices = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfServices);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        executorService.submit(new RunnableTask1(cyclicBarrier));
        executorService.submit(new RunnableTask2(cyclicBarrier));
        executorService.submit(new RunnableTask3(cyclicBarrier));
        executorService.shutdown();
        System.out.println(Thread.currentThread().getName() + " Thread Finished");
    }
}

class RunnableTask1 implements Runnable{
    private final CyclicBarrier cyclicBarrier;

    public RunnableTask1(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " service started");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Thread is waiting at the barrier");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("error to wait at the barrier ");
        }
    }
}

class RunnableTask2 implements Runnable{
    private final CyclicBarrier cyclicBarrier;

    public RunnableTask2(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " service started");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Thread is waiting at the barrier");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("error to wait at the barrier ");
        }
    }
}

class RunnableTask3 implements Runnable{
    private final CyclicBarrier cyclicBarrier;

    public RunnableTask3(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        System.out.println("Task processed by " + Thread.currentThread().getName());
        try {
            System.out.println(Thread.currentThread().getName() + " service started");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Thread is waiting at the barrier");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("error to wait at the barrier ");
        }
    }
}


