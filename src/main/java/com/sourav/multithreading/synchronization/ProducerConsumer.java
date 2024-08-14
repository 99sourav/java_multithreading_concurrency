package com.sourav.multithreading.synchronization;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private int bufferQueueSize;
    public ProducerConsumer(int size){
        this.bufferQueueSize=size;
    }
    Queue<Integer> bufferQueue = new LinkedList<>();
    public synchronized void produce(int item){
        if (bufferQueue.size() == bufferQueueSize){
            System.out.println("bufferQueue is full, wait for consumer to consume item");
            try {
                wait(); // Inter Thread Communication
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bufferQueue.add(item);
        System.out.println("produced item " + item);
        // notify consumer to consume item
        notify();  // Inter Thread Communication
    }
    public synchronized void consume(){
        if (bufferQueue.isEmpty()){
            try {
                System.out.println("buffer queue is empty, " + Thread.currentThread().getName() + " need to wait");
                wait(); // Inter Thread Communication
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
            int item = bufferQueue.poll();
            System.out.println("consumed item " + item);
            // notify producer to produce item
            notify(); // Inter Thread Communication
    }
}
