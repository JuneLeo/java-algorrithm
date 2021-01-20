package com.algorithm.sample.algo;

public class InsertSort {
    public static void main(String[] args) {
        /**
         * 插入排序
         */
        int[] insertArray = ArrayCode.ARRAY;
//        int [] insertArray = {9,7,8,13,4,2,36,3,5,4,9};
        long startTime = System.currentTimeMillis();
        insertSort(insertArray);
        System.out.println("insertArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < insertArray.length; i++) {
            System.out.print(insertArray[i] + ",");
        }
        System.out.println("--------");


        /**
         * 插入排序
         */
        int[] insertArray2 = ArrayCode.ARRAY;
//        int [] insertArray2 = {9,7,8,13,4,2,36,3,5,4,9};
        long startTime2 = System.currentTimeMillis();
        insertSort2(insertArray2);
        System.out.println("insertArray time : " + (System.currentTimeMillis() - startTime2));
        for (int i = 0; i < insertArray2.length; i++) {
            System.out.print(insertArray2[i] + ",");
        }
        System.out.println("--------");

    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    static int[] insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j - 1 >= 0 && array[j - 1] > array[j]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
        return array;
    }

}
