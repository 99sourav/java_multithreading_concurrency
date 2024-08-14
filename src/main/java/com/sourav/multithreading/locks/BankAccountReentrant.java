package com.sourav.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountReentrant {
    private final Lock lock = new ReentrantLock(true); // maintain fairness of lock | maintain a FIFO order of threads request 
    private int balance = 100;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(10000, TimeUnit.MILLISECONDS)){
                if (balance>=amount){
                    System.out.println(Thread.currentThread().getName() + " proceeding with the withdrawal");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    balance = balance - amount;
                    System.out.println("Completed withdrawl, remaining balance " + balance);
                }else {
                    System.out.println("Insufficient balance " + balance);
                }
            }else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
            if (Thread.interrupted()){
                System.out.println(Thread.currentThread().getName() + " Interrupted occured");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            lock.unlock();
        }
    }
}
