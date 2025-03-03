package com.kdda.multiThreads.completableFuture;

import java.util.concurrent.*;
import java.util.List;
import java.util.stream.Collectors;

public class CompletableFutureCombineDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // 模拟多个异步任务
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "Result from Future 1";
        }, executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Result from Future 2";
        }, executor);

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            sleep(3);
            return "Result from Future 3";
        }, executor);

        // 将所有 futures 放入列表
        List<CompletableFuture<String>> futures = List.of(future1, future2, future3);

        // 使用 allOf 等待所有任务完成
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future1, future2, future3);

        // 组合结果
        CompletableFuture<List<String>> allResults = allOfFuture.thenApply(v -> 
            futures.stream()
                   .map(CompletableFuture::join) // 获取每个 CompletableFuture 的结果
                   .collect(Collectors.toList())
        );

        // 打印结果
        try {
            List<String> results = allResults.get(); // 等待并获取结果
            System.out.println("Combined results: " + results);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // 关闭线程池
        }
    }

    // 模拟延迟操作
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
