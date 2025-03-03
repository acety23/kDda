package com.kdda.multiThreads.alternatePrinting;

/**
 * <p>  </p>
 *
 * @author tiyong
 * @date 15/10/2024 15:47
 */
public class PrintABC {
    private final Object lock = new Object();
    private int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        PrintABC printABC = new PrintABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printB();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                printABC.printC();
            }
        }).start();
    }

    private void printA() {
        synchronized (lock) {
            int i = 0;
            for (i = 0; i < 10; i++) {
                while (flag != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(i + "A");
                flag = 1;
                lock.notify();
            }
        }
    }

    private void printB() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                while (flag != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print("B");
                flag = 2;
                lock.notify();
            }
        }
    }

    private void printC() {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                while (flag != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("C");
                flag = 0;
                lock.notify();
            }
        }
    }
}
