package com.kdda.multiThreads.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentHashMapDemo {
    private static Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put(i, "value" + i);
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ConcurrentHashMap能够正确处理并发操作
        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());
    }
}
