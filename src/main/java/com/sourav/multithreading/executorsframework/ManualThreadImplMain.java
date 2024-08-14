package com.sourav.multithreading.executorsframework;

public class ManualThreadImplMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread manualThread = new Thread(()->{
                System.out.println("factorial of " + finalI + " " + factorial(finalI));
            }, "manualThread");
            manualThread.start();
            try {
                manualThread.join();
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
