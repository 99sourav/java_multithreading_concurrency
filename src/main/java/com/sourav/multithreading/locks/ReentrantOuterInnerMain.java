package com.sourav.multithreading.locks;

public class ReentrantOuterInnerMain {
    public static void main(String[] args) {
        ReentrantOuterInner reentrantOuterInnerObj = new ReentrantOuterInner();
        Thread thread = new Thread(()->{
            reentrantOuterInnerObj.outerMethod();
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Error :{} " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
