package com.sourav.multithreading.locks;

public class BankAccountReentrantMain {
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
            System.out.println("Error :{} " + e.getMessage());
        }
        System.out.println("execution finished by thread name " + Thread.currentThread().getName());
    }
}
