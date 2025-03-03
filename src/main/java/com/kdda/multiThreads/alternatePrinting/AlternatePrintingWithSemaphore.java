package com.kdda.multiThreads.alternatePrinting;

import java.util.concurrent.Semaphore;

class AlternatePrintingWithSemaphore {
    private final Semaphore semaphore1 = new Semaphore(1); // 控制线程1
    private final Semaphore semaphore2 = new Semaphore(0); // 控制线程2

    public void printOdd() throws InterruptedException {
        for (int i = 1; i <= 9; i += 2) {
            semaphore1.acquire();
            System.out.println("Thread1: " + i);
            semaphore2.release();
        }
    }

    public void printEven() throws InterruptedException {
        for (int i = 2; i <= 10; i += 2) {
            semaphore2.acquire();
            System.out.println("Thread2: " + i);
            semaphore1.release();
        }
    }

    public static void main(String[] args) {
        AlternatePrintingWithSemaphore ap = new AlternatePrintingWithSemaphore();
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
