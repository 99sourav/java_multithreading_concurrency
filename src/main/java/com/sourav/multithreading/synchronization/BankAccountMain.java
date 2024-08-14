package com.sourav.multithreading.synchronization;

public class BankAccountMain {
    public static void main(String[] args) {
        // BankAccount obj usage
        BankAccount bankAccountObj = new BankAccount();
        Thread bankAccountThread1 = new Thread(()->{
            bankAccountObj.withdraw(50);
        }, "bankAccountThread1");
        Thread bankAccountThread2 = new Thread(()->{
            bankAccountObj.withdraw(50);
        }, "bankAccountThread2");
        bankAccountThread1.start();
        bankAccountThread2.start();
        try {
            bankAccountThread1.join();
            bankAccountThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
    }
}
