package com.kdda.multiThreads.completableFuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
CompletableFuture是一个类，实现了Future和CompletionStage接口；
不像FutureTask实现了Runnable接口，所以CompleteFuture需要传入任务才可以执行；
因为实现了Future接口，所以get()等阻塞方法还可以使用。
 */
public class CompletableFutureDemo {

    private static ExecutorService executorService;
    static {
        executorService = Executors.newFixedThreadPool(10);
    }
    @Test
    public void normal() {
        /*
        runAsync() 方法执行任务是没有返回值的
        public static CompletableFuture<Void> runAsync(Runnable runnable)
        public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
         */

        Runnable runnable = new Thread(() -> System.out.println("执行没有返回值的任务"));
        CompletableFuture future1 = CompletableFuture.runAsync(runnable, executorService);

        /*
        supplyAsync() 方法执行任务则支持返回值
        public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier)
        public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor)
         */
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "执行有返回值的任务");

        System.out.println(future2.join());
    }

    @Test
    // 返回跑的最快的future，最快的如果发生异常，则玩完
    public void anyOf() {
        // anyOf 返回跑的最快的future，最快的如果发生异常，则玩完
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "朋友小王去你家送药";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "朋友小张去你家送药";
        });
//        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
//            throw new RuntimeException("Test");
//        });
        CompletableFuture<Object> anyFutures = CompletableFuture.anyOf(future2, future1);
        System.out.println(anyFutures.join());
    }

    @Test
    // 全部并行执行，如果需要获得返回值，需要配合thenApply，异常会抛出，不影响其他任务
    public void allOf() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("future1");
            return 15;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Test");
        });
        CompletableFuture<Integer> allFutures = CompletableFuture.allOf(future1, future2, future3).thenApply(res -> {
            return future1.join()  + future2.join();
        });
        System.out.println(allFutures.join());
    }

    @Test
    // whenComplete、handle
    // 出现异常不会中段，throwable参数会接收前面的任务的异常，异常会通过get抛出到主线程
    public void callBack() {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(111);
            return 444;
        });

        // whenComplete() = thenAccept 没有返回值，且返回的CompletableFuture为任务结果，而非回调结果
        CompletableFuture<Integer> future1Callback = future1.whenComplete((result, throwable) -> {
            System.out.println(222);
        }).whenComplete((result, throwable) -> {
            System.out.println(333);
//            throw new RuntimeException("Test");
        });
        System.out.println(future1Callback.join());


        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "返回任务结果";
        });

        // handle() = thenApply 有返回值，且返回的CompletableFuture为回调结果
        CompletableFuture<String> future2Callback = future2.handle((result, throwable) -> {
            return result + ",返回回调结果";
        });
        System.out.println(future2Callback.join());
    }

    @Test
    // 链式调用
    public void chain() {

        // thenRun(Runnable runnable): 对异步任务的结果进行操作，不能传入参，也没有返回值
        // !!!!!! 注意！当前面任务执行完，theRun的任务会由主线程执行，没有执行完的话会由前面的任务的线程执行，不想用前面的方式的话用thenRunAsync的话会用CompletableFuture内置的线程池执行，thenApply同
        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.print(Thread.currentThread().getName());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行第一个任务");
            return 0;
        }).thenRun(() -> {
            System.out.print(Thread.currentThread().getName());
            System.out.println("执行第二个任务");
        }).thenRun(() -> {
            System.out.print(Thread.currentThread().getName());
            System.out.println("执行第三个任务");
        }).thenRunAsync(() -> {
            System.out.print(Thread.currentThread().getName());
            System.out.println("执行第四个任务");
        });

        // thenAccept(Consumer consumer): 可传入参数
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> 5)
                .thenAccept(result -> {
                    System.out.println("任务执行结果 = " + result * 3);
                }).thenAccept(result -> {
                    System.out.println("任务执行完成");
                });

        // thenApply(Function function): 可传入参数，并返回结果
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 5)
                .thenApply(result -> result * 3)
                .thenApply(result -> result + 3);

        System.out.println(future3.join());
    }
}