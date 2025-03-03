package com.kdda.multiThreads.alternatePrinting;

class AlternatePrintingWithLock {
    private final Object lock = new Object();
    private boolean isThread1Turn = true;

    public void printOdd() throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= 9; i += 2) {
                while (!isThread1Turn) {
                    lock.wait();
                }
                System.out.println("Thread1: " + i);
                isThread1Turn = false;
                lock.notify();
            }
        }
    }

    public void printEven() throws InterruptedException {
        synchronized (lock) {
            for (int i = 2; i <= 10; i += 2) {
                while (isThread1Turn) {
                    lock.wait();
                }
                System.out.println("Thread2: " + i);
                isThread1Turn = true;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrintingWithLock ap = new AlternatePrintingWithLock();
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
