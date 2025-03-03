package com.kdda.multiThreads.threadLoacl;

import java.text.SimpleDateFormat;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
    SimpleDateFormat s = new SimpleDateFormat();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 initial: " + threadLocal.get());
            threadLocal.set(100);
            System.out.println("Thread 1 after set: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 initial: " + threadLocal.get());
            threadLocal.set(200);
            System.out.println("Thread 2 after set: " + threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
