package com.sourav.multithreading.threadcreation;

public class ThreadCreationMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("execution started by thread name " + Thread.currentThread().getName());
        // create an instance or object of custom thread class
        MultiThread1 multiThread1 = new MultiThread1("MultiThread1"); //  Thread is in new state
        System.out.println(multiThread1.getState());
        multiThread1.start(); // Thread is in runnable state, waiting for cpu to execute this thread
        System.out.println(multiThread1.getState());
        MultiThread2 multiThread2 = new MultiThread2();  // here MultiThread2 is runnable class, and multiThread2 is runnable object
        Thread thread = new Thread(multiThread2, "MultiThread2");
        System.out.println(thread.getState());
        thread.start();  // Thread is in runnable state, waiting for cpu to execute this thread
        System.out.println(thread.getState());
        thread.join(); // after multiThread2 will finish it's work, then only main thread will run
        System.out.println(thread.getState());
        Thread.sleep(5000);
        System.out.println("execution finished by thread name " + Thread.currentThread().getName());
    }
}
