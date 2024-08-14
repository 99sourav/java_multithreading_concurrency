package com.sourav.multithreading.synchronization;

public class SharedResource {
    public synchronized void task1(){
        System.out.println(" inside task1 method, under synchronized block, access by Thread name " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void task2(){
        System.out.println("inside task2 method, but before synchronized block, access by Thread name " + Thread.currentThread().getName());
        synchronized (this){
            System.out.println("inside task2 method, inside synchronized block, access by Thread name " + Thread.currentThread().getName());
        }
    }
    public void task3(){
        System.out.println("inside task3 method, no synchronization block, access by Thread name " + Thread.currentThread().getName());
    }
}
