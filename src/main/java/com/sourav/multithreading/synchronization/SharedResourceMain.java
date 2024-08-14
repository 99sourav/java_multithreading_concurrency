package com.sourav.multithreading.synchronization;

public class SharedResourceMain {
    public static void main(String[] args) {
        // SharedResource obj usage
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(()->{
            sharedResource.task1();  // thread using lambda expression
        }, "thread1");
        Thread thread2 = new Thread(()->{
            sharedResource.task2();
        }, "thread2");
        Thread thread3 = new Thread(()->{
            sharedResource.task3();
        }, "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
    }
}
