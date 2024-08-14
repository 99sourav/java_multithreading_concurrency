package com.sourav.multithreading.threadmethods;

public class MultiThread3 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();  // A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
        }
    }
}
