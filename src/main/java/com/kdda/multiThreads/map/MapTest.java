package com.kdda.multiThreads.map;

import java.util.HashMap;

/**
 * <p>  </p>
 *
 * @author tiyong
 * @date 16/10/2024 0:33
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                map.put(i, "Value " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (Integer key : map.keySet()) {  // 遍历时可能发生无限循环
                System.out.println(key + ": " + map.get(key));
            }
        });

        t1.start();
        t2.start();

    }
}
