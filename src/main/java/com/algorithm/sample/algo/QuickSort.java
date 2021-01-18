package com.algorithm.sample.algo;

public class QuickSort {
    public static void main(String[] args) {
        /**
         * 快速排序
         */
        int[] quickArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        System.out.println("quickArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < quickArray.length; i++) {
            System.out.print(quickArray[i] + ",");
        }
        System.out.println("--------");
    }
    /**
     * 快排
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            int key = array[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && array[j] >= key) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && array[i] <= key) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = key;
            quickSort(array, start, i - 1);
            quickSort(array, i + 1, end);
        }
        return array;
    }
}
