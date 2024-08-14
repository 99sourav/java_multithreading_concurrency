package com.sourav.multithreading.locks;

public class ReentrantLockExample {
    public static void main(String[] args) {
        // BankAccountReentrant obj usage
        BankAccountReentrant bankAccountReentrantObj = new BankAccountReentrant();
        Thread bankAccountth1 = new Thread(()->{
            bankAccountReentrantObj.withdraw(50);
        }, "bankAccountth1");
        Thread bankAccountth2 = new Thread(()->{
            bankAccountReentrantObj.withdraw(50);
        }, "bankAccountth2");
        bankAccountth1.start();
        bankAccountth2.start();
        try {
            bankAccountth1.join();
            bankAccountth2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // InterruptibleLockExample obj usage
        InterruptibleLockExample interruptibleLockObj = new InterruptibleLockExample();
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
            System.out.println("exception " + e);
        }
        System.out.println("execution finished by thread name " + Thread.currentThread().getName());
    }
}
