package com.algorithm.sample.algo;

public class SelectSort {
    // 它的工作原理是：第一次从待排序的数据元素中选出最小 的一个元素，存放在序列的起始位置，
    // 然后再从剩余的未排序元素中寻找到最小元素，然后放到已排序的序列的末尾 。
    // 以此类推，直到全部待排序的数据元素的个数为零。
    public static void main(String[] args) {
        /**
         * 选择排序
         */
        int[] selectArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        selectSort2(selectArray);
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

    static void selectSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

}
