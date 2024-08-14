package com.sourav.multithreading.executorsframework;

public class ThreadArrayImplMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread[] threadArr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadArr[i] = new Thread(()->{
                System.out.println("factorial of " + finalI + " " + factorial(finalI));
            }, "manualThread");
            threadArr[i].start();
        }
        for (Thread thread:threadArr){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("total time " + (System.currentTimeMillis()-startTime));
    }
    private static int factorial(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (i==0){
            return 1;
        }
        int fact = 1;
        for (int j = i; j > 0; j--) {
            fact = fact*j;
        }
        return fact;
    }
}
