package com.sourav.multithreading.locks;

public class InterruptibleLockMain {
    public static void main(String[] args) {
        // InterruptibleLockExample obj usage
        InterruptibleLock interruptibleLockObj = new InterruptibleLock();
        Thread interruptibleLockTh1 = new Thread(()->{
            interruptibleLockObj.performTask();
        }, "interruptibleLockTh1");
        Thread interruptibleLockTh2 = new Thread(()->{
            interruptibleLockObj.performTask();
        }, "interruptibleLockTh2");
        interruptibleLockTh1.start();
        interruptibleLockTh2.start();
        try {
            // Interrupt thread2 after 1 second
            Thread.sleep(1000);
            interruptibleLockTh2.interrupt();
            interruptibleLockTh1.join();
            interruptibleLockTh2.join();
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
        System.out.println("execution finished by thread name " + Thread.currentThread().getName());
    }
}
