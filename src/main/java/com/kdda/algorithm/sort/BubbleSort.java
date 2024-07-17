package com.kdda.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public static void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Integer tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(1);
        integers.add(6);
        integers.add(7);
        integers.add(9);
        BubbleSort.sort(integers);
    }
}
