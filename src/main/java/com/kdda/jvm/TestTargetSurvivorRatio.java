package com.kdda.jvm;

public class TestTargetSurvivorRatio {
    private static final int MB = 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
        byte[] b1 = new byte[MB * 33];
        byte[] b2 = new byte[MB * 33];
        byte[] a1 = new byte[MB * 3];
        b1 = null;
        b2 = null;
        System.out.println("--------1 start");
        b1 = new byte[MB * 33];
        // 垃圾回收完成后：
        // 大概1M的系统垃圾+3M的a1进入Survivor，垃圾回收完成后，这些对象就是年龄1
        System.out.println("--------1 end");
        b2 = new byte[MB * 33];
        byte[] a2 = new byte[MB * 3];
        b1 = null;
        b2 = null;
        System.out.println("--------2 start");
        // 垃圾回收前，Survivor中的对象年龄1到N的大小不足50%
        // 因此在回收的时候年龄1的对象不会进入老年代
        b1 = new byte[MB * 33];
        // 垃圾回收完成后：
        // Survivor中原有的大概1M的系统垃圾+3M的a1变成年龄2
        // 新进入Survivor的3M的a2就是年龄1
        System.out.println("--------2 end");
        b2 = new byte[MB * 33];
        byte[] a3 = new byte[MB * 3];
        b1 = null;
        b2 = null;
        System.out.println("--------3 start");
        // 垃圾回收前，年龄2有大概4M，年龄1大概有3M，超过Survivor的50%
        // 因此在回收的时候年龄2的4M会进入老年代
        b1 = new byte[MB * 33];
        // 垃圾回收完成后：
        // Survivor中3M的a2年龄变成2
        // 新进入的3M的a3为年龄1
        // 老年代中的则是原先的系统大概1M和3M的a1
        System.out.println("--------3 end");
    }
}
