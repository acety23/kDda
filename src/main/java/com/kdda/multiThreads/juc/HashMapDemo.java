package com.kdda.multiThreads.juc;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    private static Map<Integer, String> hashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                hashMap.put(i, "value" + i);
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

        Thread.sleep(1000);
        // 可能会出现线程问题，导致HashMap大小不正确，数据丢失
        System.out.println("HashMap size: " + hashMap.size());
        System.out.println("");
    }
}
