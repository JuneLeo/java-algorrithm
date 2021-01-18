package com.algorithm.sample.algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        /**
         * 归并排序
         */
        int[] mergeArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        mergeArray = mergeSort(mergeArray);
        System.out.println("mergeArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < mergeArray.length; i++) {
            System.out.print(mergeArray[i] + ",");
        }
        System.out.println("--------");
    }
    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    static int[] merge(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        int i = 0, j = 0, index = 0;
        while (index < array.length && i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                array[index++] = a[i++];
            } else {
                array[index++] = b[j++];
            }
        }
        while (i < a.length) {
            array[index++] = a[i++];
        }
        while (j < b.length) {
            array[index++] = b[j++];
        }
        return array;
    }
}
