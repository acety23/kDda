package com.kdda.algorithm.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] unsortedArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        quickSort(unsortedArray, 0, unsortedArray.length - 1);

        for (int num : unsortedArray) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
