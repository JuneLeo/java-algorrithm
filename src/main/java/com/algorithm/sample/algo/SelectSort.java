package com.algorithm.sample.algo;

public class SelectSort {
    public static void main(String[] args) {
        /**
         * 选择排序
         */
        int[] selectArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        selectSort(selectArray);
        System.out.println("selectArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < selectArray.length; i++) {
            System.out.print(selectArray[i] + ",");
        }
        System.out.println("--------");
    }

    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
