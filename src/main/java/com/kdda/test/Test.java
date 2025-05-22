package com.kdda.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>  </p>
 *
 * @author tiyong
 * @date 28/10/2024 19:01
 */
public class Test {
    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        Integer num = 128;
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synTest.fun1(num);
                }
            }).start();
        }
    }
}
class SynTest {
    public void fun1(Integer num) {
        synchronized (num) {
            num++;
            System.out.println("start...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stop");
        }
    }
}
