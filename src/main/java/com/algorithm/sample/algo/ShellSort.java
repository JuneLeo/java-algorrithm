package com.algorithm.sample.algo;

public class ShellSort {
    public static void main(String[] args) {
        /**
         * 希尔排序
         */
        int[] shellArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        shelltSort(shellArray);
        System.out.println("shellArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < shellArray.length; i++) {
            System.out.print(shellArray[i] + ",");
        }
        System.out.println("--------");
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    static int[] shelltSort(int[] array) {
        for (int i = array.length / 2; i >= 1; i = i / 2) {
            for (int j = 0; j < i; j++) {
                //插入排序交换组内数据
                int index = j;
                while (index < array.length) {
                    int tempIndex = index;
                    while ((tempIndex - i) >= 0 && array[tempIndex - i] > array[tempIndex]) {
                        int temp = array[tempIndex - i];
                        array[tempIndex - i] = array[tempIndex];
                        array[tempIndex] = temp;
                        tempIndex = tempIndex - i;
                    }
                    index = index + i;
                }
            }
        }
        return array;
    }
}
