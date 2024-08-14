package com.sourav.multithreading.threadmethods;

public class DaemonThreads extends Thread{
    public DaemonThreads(String name){
        super(name);
    }
    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
