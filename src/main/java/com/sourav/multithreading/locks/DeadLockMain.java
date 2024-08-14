package com.sourav.multithreading.locks;

public class DeadLockMain {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread penThread = new Thread(()->{
            pen.writeWithPenAndPaper(paper); // penThread locks pen and tries to lock paper
        }, "penThread");
        Thread paperThread = new Thread(()->{
            paper.writeWithPaperAndPen(pen); // paperThread locks paper and tries to lock pen
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

// DeadLock Implementation
class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " using pen obj " + this + " trying to acquire paper obj " + paper);
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finished writing with pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " using paper obj " + this + " trying to acquire pen obj " + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished writing with paper " + this);
    }
}



