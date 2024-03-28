package com.algorithm.sample.algo;

public class ShellSort {
    public static void main(String[] args) {
        /**
         * 希尔排序
         */
        int[] shellArray = ArrayCode.ARRAY;
//        int [] shellArray = {9,7,8,13,4,2,36,3,5,4,9};
        long startTime = System.currentTimeMillis();
        shelltSort(shellArray);
        System.out.println("shellArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < shellArray.length; i++) {
            System.out.print(shellArray[i] + ",");
        }
        System.out.println("--------");

        int[] shellArray2 = ArrayCode.ARRAY;
//        int [] shellArray2 = {9,7,8,13,4,2,36,3,5,4,9};
        long startTime2 = System.currentTimeMillis();
        shelltSort2(shellArray2);
        System.out.println("shellArray time : " + (System.currentTimeMillis() - startTime2));
        for (int i = 0; i < shellArray.length; i++) {
            System.out.print(shellArray2[i] + ",");
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


    static int[] shelltSort2(int[] array) {
        for (int i = array.length / 2; i >= 1; i = i / 2) {
            for (int j = 0; j < i; j++) { //几组
                for (int k = j + i; k < array.length; k += i) { //组内数据
                    int index = k;
                    while (index - i >= 0 && array[index - i] > array[index]) { // 分别和前面的数据比较
                        int temp = array[index - i];
                        array[index - i] = array[index];
                        array[index] = temp;
                        index -= i;
                    }
                }
            }
        }
        return array;
    }

}
