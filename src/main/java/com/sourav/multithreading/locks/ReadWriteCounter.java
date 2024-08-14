package com.sourav.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public int setCount(){
        try {
            writeLock.lock();
            count++;
        }catch (Exception e){
            System.out.println("error to lock " + e);
        }finally {
            writeLock.unlock();
        }
        return count;
    }

    public int getCount(){
        try {
            readLock.lock();
        }catch (Exception e){
            System.out.println("error to lock " + e);
        }finally {
            readLock.unlock();
        }
        return count;
    }
}
