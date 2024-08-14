package com.sourav.multithreading.synchronization;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        // ProducerConsumer obj usage
        ProducerConsumer producerConsumer = new ProducerConsumer(3);
        Thread producerThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                producerConsumer.produce(i);
            }
        }, "producerThread");
        Thread consumerThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                producerConsumer.consume();
            }
        }, "consumerThread");
        producerThread.start();
        consumerThread.start();
    }
}
