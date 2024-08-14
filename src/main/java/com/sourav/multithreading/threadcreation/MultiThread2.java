package com.sourav.multithreading.threadcreation;

public class MultiThread2 implements Runnable{
    // create a class that implements runnable interface
    @Override
    public void run() {
        // Thread is in running state
        // Task which MultiThread2 need to execute
        System.out.println(Thread.currentThread().getName() + " is in running state");
        System.out.println("execution started by thread name " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted " + e);
        }
    }
}
