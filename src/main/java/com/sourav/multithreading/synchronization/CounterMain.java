package com.sourav.multithreading.synchronization;

public class CounterMain {
    public static void main(String[] args) {
        Counter counterObj = new Counter();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counterObj.incrementCount();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counterObj.incrementCount();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("error to block main thread :{}" + e);
        }
        System.out.println("Count: " + counterObj.getCount());
    }
}

class Counter{
    private int count = 0;

    public int getCount() {
        return count;
    }
    // Synchronized method to ensure atomic operation
    public synchronized void incrementCount(){
        count++;  // Critical section
    }
}
