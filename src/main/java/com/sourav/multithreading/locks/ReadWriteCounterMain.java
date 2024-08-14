package com.sourav.multithreading.locks;

public class ReadWriteCounterMain {
    public static void main(String[] args) {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Thread readThread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read value " + readWriteCounter.getCount());
            }
        }, "readThread");
        Thread writeThread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " write value " + readWriteCounter.setCount());
            }
        }, "writeThread");
        Thread readThread1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " read value " + readWriteCounter.getCount());
            }
        }, "readThread1");
        readThread.start();
        writeThread.start();
        readThread1.start();
        try {
            readThread.join();
            writeThread.join();
            readThread1.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        }
        System.out.println("finished main thread with count " + readWriteCounter.getCount());
    }
}
