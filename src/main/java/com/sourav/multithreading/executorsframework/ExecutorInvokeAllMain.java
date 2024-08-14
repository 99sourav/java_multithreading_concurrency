package com.sourav.multithreading.executorsframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeAllMain {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new NewCustomThreadFactory(), new NewCustomRejectHandler());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Callable<Integer> callableTask1 = ()->{
            Thread.sleep(2000);
            System.out.println("Task1");
            return 99;
        };
        Callable<Integer> callableTask2 = ()->{
            Thread.sleep(2000);
            System.out.println("Task2");
            return 101;
        };
        Callable<Integer> callableTask3 = ()->{
            Thread.sleep(2000);
            System.out.println("Task3");
            return 89;
        };
        List<Callable<Integer>> callableTaskList = Arrays.asList(callableTask1, callableTask2, callableTask3);
        try {
            List<Future<Integer>> futureObjList = threadPoolExecutor.invokeAll(callableTaskList, 2000, TimeUnit.MILLISECONDS);
            threadPoolExecutor.shutdown();
            for (Future<Integer> futureObj:futureObjList){
                System.out.println("result " + futureObj.get());
            }
        } catch (CancellationException | InterruptedException | ExecutionException e) {
            System.out.println("error to execute task " + e);
        }
    }
}
