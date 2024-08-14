package com.sourav.multithreading.synchronization;

public class Synchronization {
    public static void main(String[] args) {
//        // SharedResource obj usage
//        SharedResource sharedResource = new SharedResource();
//        Thread thread1 = new Thread(()->{
//            sharedResource.task1();  // thread using lambda expression
//        }, "thread1");
//        Thread thread2 = new Thread(()->{
//            sharedResource.task2();
//        }, "thread2");
//        Thread thread3 = new Thread(()->{
//            sharedResource.task3();
//        }, "thread3");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        try {
//            thread1.join();
//            thread2.join();
//            thread3.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

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
            throw new RuntimeException(e);
        }

//        // ProducerConsumer obj usage
//        ProducerConsumer producerConsumer = new ProducerConsumer(3);
//        Thread producerThread = new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                producerConsumer.produce(i);
//            }
//        }, "producerThread");
//        Thread consumerThread = new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                producerConsumer.consume();
//            }
//        }, "consumerThread");
//        producerThread.start();
//        consumerThread.start();
    }
}
