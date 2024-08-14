package com.sourav.multithreading.threadmethods;
import com.sourav.multithreading.threadcreation.MultiThread1;
import com.sourav.multithreading.threadcreation.MultiThread2;

public class ThreadMethods {
    public static void main(String[] args) {
        MultiThread1 multiThread1 = new MultiThread1("MultiThread1");
        multiThread1.setPriority(Thread.MIN_PRIORITY);
        multiThread1.start(); // Begins the execution of the thread.JVM calls the run() method of the thread
        multiThread1.interrupt();
        MultiThread2 multiThread2 = new MultiThread2();
        Thread thread = new Thread(multiThread2, "MultiThread2");
        thread.setPriority(Thread.MAX_PRIORITY); // setPriority(int priority) sets the priority of the thread, While the JVM may consider thread priorities, it is not guaranteed to honor them, as scheduling policies depend on the underlying operating system
        thread.start();  // Begins the execution of the thread.JVM calls the run() method of the thread
        try {
            thread.join(); // after multiThread2 will finish it's work, then only main thread will run
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(5000); // thread wait for specific period of time and come back to runnable state
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MultiThread3 multiThread3 = new MultiThread3();
        Thread thread1 = new Thread(multiThread3, "MultiThread3"); // user threads , The JVM will continue running until this thread finishes its task
        thread1.start();  // check yield() is working internally or not
        Thread thread2 = new Thread(multiThread3, "MultiThread4"); // user threads , The JVM will continue running until this thread finishes its task
        thread2.start();  // check yield() is working internally or not
        DaemonThreads daemonThreads = new DaemonThreads("DaemonThreads");
        daemonThreads.setDaemon(true); // daemon threads , The JVM exits when all running threads are daemon threads
        daemonThreads.start();
        try {
            Thread.sleep(3000); // thread wait for specific period of time and come back to runnable state
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("execution finished by thread name " + Thread.currentThread().getName());
    }
}
