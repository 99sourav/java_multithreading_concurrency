package com.sourav.multithreading.threadcreation;

public class MultiThread1 extends Thread{
    // Thread subclass by extending Thread class
    public MultiThread1(String name){
        super(name);  // set Thread name by using constructor
    }
    @Override
    public void run() {
        // Thread is in running state
        // Task which MultiThread1 need to execute
        System.out.println(Thread.currentThread().getName() + " is in running state");
        System.out.println("execution started by thread name " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
