package com.algorithm.sample.algo;

public class BubbleSort {
    public static void main(String[] args) {
        /**
         * 冒泡排序 时间复杂度 O(n^2)
         */
        int[] bubbleArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        bubbleSort2(bubbleArray);
        System.out.println("bubbleArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < bubbleArray.length; i++) {
            System.out.print(bubbleArray[i] + ",");
        }
        System.out.println("--------");
    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    static void bubbleSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

}
