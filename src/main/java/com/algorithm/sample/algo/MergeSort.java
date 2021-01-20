package com.algorithm.sample.algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        /**
         * 归并排序
         */
//        int[] mergeArray = ArrayCode.ARRAY;
//        long startTime = System.currentTimeMillis();
//        mergeArray = mergeSort(mergeArray);
//        System.out.println("mergeArray time : " + (System.currentTimeMillis() - startTime));
//        for (int i = 0; i < mergeArray.length; i++) {
//            System.out.print(mergeArray[i] + ",");
//        }
//        System.out.println("--------");

        int[] mergeArray2 = {9, 7, 8, 13, 4, 2, 36, 3, 5, 4, 9};
        long startTime = System.currentTimeMillis();
        mergeArray2 = mergeSort2(mergeArray2);
        System.out.println("mergeArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < mergeArray2.length; i++) {
            System.out.print(mergeArray2[i] + ",");
        }
        System.out.println("--------");
    }


    public static int[] mergeSort2(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);

        return merge2(mergeSort2(left), mergeSort2(right));
    }

    private static int[] merge2(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];
        int i = 0, j = 0, index = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[index++] = left[i++];
            } else {
                array[index++] = right[j++];
            }
        }
        while (i < left.length) {
            array[index++] = left[i++];
        }

        while (j < right.length) {
            array[index++] = right[j++];
        }
        return array;
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
