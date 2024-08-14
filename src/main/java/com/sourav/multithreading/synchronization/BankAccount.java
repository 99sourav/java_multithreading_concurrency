package com.sourav.multithreading.synchronization;

public class BankAccount {
    private int balance = 100;
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (balance>=amount){
            System.out.println(Thread.currentThread().getName() + " proceeding with the withdrawal");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance = balance - amount;
            System.out.println("Completed withdrawl, remaining balance " + balance);
        }else {
            System.out.println("Insufficient balance " + balance);
        }
    }
}
