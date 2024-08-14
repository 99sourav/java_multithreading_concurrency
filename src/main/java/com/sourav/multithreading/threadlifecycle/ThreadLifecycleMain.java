package com.sourav.multithreading.threadlifecycle;

public class ThreadLifecycleMain {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("Thread is running");
            try {
                Thread.sleep(500); // Timed Waiting State
                System.out.println("Thread state after sleep inside run(): " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                System.out.println("Error :{} " + e.getMessage());
            }
            System.out.println("Thread is finishing");
        });

        // New State
        System.out.println("Thread state after creation: " + thread.getState());

        thread.start(); // Runnable State
        System.out.println("Thread state after calling start(): " + thread.getState());

        try {
            Thread.sleep(100); // Ensuring the thread has started
            System.out.println("Thread state after sleeping for 100ms: " + thread.getState());

            thread.join(); // Waiting for thread to complete
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }

        // Terminated State
        System.out.println("Thread state after completion: " + thread.getState());
    }
}
