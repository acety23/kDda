package com.kdda.algorithm.sort;

import java.util.*;
import java.util.stream.Collectors;


// 插入排序通过把待排序元素插入有序序列中来完成排序的一种算法，下面是用Java实现插入排序的相关代码
public class InertSort {
    public static void sort(int[] array) {
        int targetIndex;
        for (int currIndex = 1; currIndex < array.length; currIndex++) {
            int currValue = array[currIndex];
            for (targetIndex = currIndex; targetIndex > 0 && array[targetIndex - 1] > currValue; targetIndex--) {
                array[targetIndex] = array[targetIndex - 1];
            }
            array[targetIndex] = currValue;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 6, 3, 2, 2, 1};
        InertSort.sort(array);
        System.out.println(Arrays.toString(array));
        String[] strs = new String[]{"a", "b", "c"};
        List<String> strings = Arrays.asList(strs);
    }
}
