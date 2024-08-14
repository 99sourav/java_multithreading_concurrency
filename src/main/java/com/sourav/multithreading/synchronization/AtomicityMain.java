package com.sourav.multithreading.synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityMain {
    public static void main(String[] args) {
        Atomicity atomicity = new Atomicity();
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                atomicity.setAtomicInteger();
            }
        });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                atomicity.setAtomicInteger();
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
        System.out.println("Count: " + atomicity.getAtomicInteger());
    }
}

class Atomicity {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger() {
        atomicInteger.incrementAndGet();
    }
}
