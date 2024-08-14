package com.sourav.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLock {
    private final Lock lock = new ReentrantLock();

    public void performTask() {
        try {
            lock.lockInterruptibly(); // Acquire the lock, but allow interruption
            try {
                // Critical section
                System.out.println(Thread.currentThread().getName() + " acquired the lock and is performing the task.");
                Thread.sleep(2000); // Simulate some work
            } finally {
                lock.unlock(); // Ensure the lock is released
                System.out.println(Thread.currentThread().getName() + " released the lock.");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }
    }
}
