package com.kdda.multiThreads.alternatePrinting;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class AlternatePrintingWithQueue {
    private final BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);
    private final BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);

    public void printOdd() throws InterruptedException {
        for (int i = 1; i <= 9; i += 2) {
            queue1.put(1); // 阻塞直到能放入
            System.out.println("Thread1: " + i);
            queue2.take(); // 释放另一个线程
        }
    }

    public void printEven() throws InterruptedException {
        for (int i = 2; i <= 10; i += 2) {
            queue1.take(); // 阻塞直到能取出
            System.out.println("Thread2: " + i);
            queue2.put(1); // 释放另一个线程
        }
    }

    public static void main(String[] args) {
        AlternatePrintingWithQueue ap = new AlternatePrintingWithQueue();
        new Thread(() -> {
            try {
                ap.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                ap.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
