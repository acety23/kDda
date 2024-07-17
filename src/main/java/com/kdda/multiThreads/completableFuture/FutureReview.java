package com.kdda.multiThreads.completableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureReview {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "futureTask1 执行完成";
            }
        });
        new Thread(futureTask1).start();

        // lambda方式
        FutureTask<String> futureTask2 = new FutureTask<>(() -> {
            Thread.sleep(2100);
            return "futureTask2 执行完成";
        });
        new Thread(futureTask2).start();

        while (true) {
            //isDone() 方法的作用是，判断任务是否执行完毕，通常在程序中轮询使用
            if (futureTask1.isDone() && futureTask2.isDone()) {
                //get() 方法的作用是，以阻塞的方式，获取任务执行结果
                //get() 方法抛出检查时异常（InterruptedException, ExecutionException），程序必须进行处理
                //join() 方法只抛出运行时异常，程序可不做处理
                System.out.println(futureTask1.get());
                System.out.println(futureTask2.get());
                break;
            }
        }
    }
}
