package com.sourav.multithreading.locks;

public class DeadLockResolveMain {
    // DeadLock Issue resolved with consistent ordering of acquiring the locks
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread penThread = new Thread(()->{
            pen.writeWithPenAndPaper(paper); // penThread locks pen and tries to lock paper
        }, "penThread");
        Thread paperThread = new Thread(()->{
            synchronized (pen){
                paper.writeWithPaperAndPen(pen); // paperThread locks paper and tries to lock pen
            }
        }, "paperThread");
        penThread.start();
        paperThread.start();
        try {
            penThread.join();
            paperThread.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred " + e);
        }
        System.out.println("finished main thread after a deadlock condition " + Thread.currentThread().getName());
    }
}
