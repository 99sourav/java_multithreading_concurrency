package com.sourav.multithreading.executorsframework;

import java.util.concurrent.*;

public class ThreadPoolExecutorMain {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new NewCustomThreadFactory(), new NewCustomRejectHandler());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 7; i++) {
            threadPoolExecutor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("exception occurred " + e);
                }
                System.out.println("Task Processed " + Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.shutdown();
    }
}

class NewCustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setName("Sourav-ThreadPoolExecutor");
        thread.setDaemon(false);
        return thread;
    }
}

class NewCustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected " + r.toString());
    }
}
