package com.sourav.multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantOuterInner {
    private final Lock lock = new ReentrantLock(true);

    public void outerMethod(){
        try {
            lock.lock();
            System.out.println("outer method");
            innerMethod();
        }catch (Exception e){
            System.out.println("Error :{} " + e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        try {
            lock.lock();
            System.out.println("inner method");
        }catch (Exception e){
            System.out.println("Error :{} " + e.getMessage());
        }finally {
            lock.unlock();
        }
    }
}
