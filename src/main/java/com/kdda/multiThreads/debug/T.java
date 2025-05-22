package com.kdda.multiThreads.debug;

public class T implements Runnable{
    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " " + lazySingleton);
    }
}
