package com.kdda.multiThreads.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo2 {

    public static void main(String[] args) {
        // 1. 创建一个基本的 CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作
            sleep(2);
            return "Hello, ";
        });

        // 2. 添加回调处理结果
        future.thenAccept(result -> {
            System.out.println(result + "World!");
        });

        // 3. 等待结果，使用 join()
        try {
            // 这里可以等待主线程，确保程序不会提前结束
            future.join(); // 或者使用 future.get()
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4. 使用 thenApply 处理结果并返回新值
        CompletableFuture<String> futureWithResult = CompletableFuture.supplyAsync(() -> {
            return "Java";
        }).thenApply(result -> {
            return result + " CompletableFuture!";
        });

        // 5. 打印结果
        futureWithResult.thenAccept(result -> {
            System.out.println(result);
        }).join(); // 确保主线程等待结果

        // 6. 组合多个 CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Result from Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "Result from Future 2";
        });

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + " and " + result2;
        });

        combinedFuture.thenAccept(result -> {
            System.out.println(result);
        }).join();

        // 7. 处理异常
        CompletableFuture<String> futureWithError = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return "This won't be executed";
        });

        futureWithError.exceptionally(ex -> {
            System.out.println("Error occurred: " + ex.getMessage());
            return "Default Value";
        }).thenAccept(result -> {
            System.out.println("Result: " + result);
        }).join();

        // 8. 完成一个 CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        // 在另一个线程中完成
        new Thread(() -> {
            sleep(1);
            completableFuture.complete("Completed!");
        }).start();

        completableFuture.thenAccept(result -> {
            System.out.println("CompletableFuture was: " + result);
        }).join();

        // 9. 超时处理
        CompletableFuture<String> futureWithTimeout = CompletableFuture.supplyAsync(() -> {
            sleep(5); // 模拟耗时操作
            return "This will timeout";
        });

        futureWithTimeout.join();

        try {
            String result = futureWithTimeout.orTimeout(3, TimeUnit.SECONDS).join(); // 设置超时
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
