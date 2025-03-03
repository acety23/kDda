package com.kdda.multiThreads.alternatePrinting;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AlternatePrintingWithReentrantLock {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isThread1Turn = true;

    public void printOdd() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 1; i <= 9; i += 2) {
                while (!isThread1Turn) {
                    condition.await();
                }
                System.out.println("Thread1: " + i);
                isThread1Turn = false;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void printEven() throws InterruptedException {
        lock.lock();
        try {
            for (int i = 2; i <= 10; i += 2) {
                while (isThread1Turn) {
                    condition.await();
                }
                System.out.println("Thread2: " + i);
                isThread1Turn = true;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AlternatePrintingWithReentrantLock ap = new AlternatePrintingWithReentrantLock();
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
