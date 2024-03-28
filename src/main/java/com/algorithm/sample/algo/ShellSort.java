package com.algorithm.sample.algo;

public class ShellSort {
    // 希尔排序是插入排序的一种又称“缩小增量排序”，是直接插入排序算法的一种更高效的改进版本。
    // 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；
    // 随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止。
    public static void main(String[] args) {
        /**
         * 希尔排序
         */
//        int[] shellArray = ArrayCode.ARRAY;
////        int [] shellArray = {9,7,8,13,4,2,36,3,5,4,9};
//        long startTime = System.currentTimeMillis();
//        shelltSort(shellArray);
//        System.out.println("shellArray time : " + (System.currentTimeMillis() - startTime));
//        for (int i = 0; i < shellArray.length; i++) {
//            System.out.print(shellArray[i] + ",");
//        }
//        System.out.println("--------");

//        int[] shellArray2 = ArrayCode.ARRAY;
        int[] shellArray2 = {9, 7, 8, 13, 4, 2, 36, 3, 5, 4, 9};
        long startTime2 = System.currentTimeMillis();
        shellSort3(shellArray2);
        System.out.println("shellArray time : " + (System.currentTimeMillis() - startTime2));
        for (int i = 0; i < shellArray2.length; i++) {
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
    static int[] shellSort(int[] array) {
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


    /**
     * 9,7,8,13,4,    2,36,3,5,4,9,
     * ----------------------
     * 2,7,8,13,4,    9,36,3,5,4,9,
     * 2,7,3,13,4,    9,36,8,5,4,9,
     * 2,7,3,5,4,9,   36,8,13,4,9,
     * <p>
     * 2,7, 3,5, 4,9, 36,8, 13,4, 9,
     * 2,7, 3,5, 4,9, 13,8, 36,4, 9,
     * 2,7, 3,5, 4,9, 13,8, 9,4, 36,
     * 2,7, 3,5, 4,9, 9,8, 13,4, 36,
     * 2,5, 3,7, 4,9, 9,8, 13,4, 36,
     * 2,5, 3,7, 4,8, 9,9, 13,4, 36,
     * 2,5, 3,7, 4,8, 9,4, 13,9, 36,
     * 2,5, 3,7, 4,4, 9,8, 13,9, 36,
     * 2,5, 3,4, 4,7, 9,8, 13,9, 36,
     * 2,4, 3,5, 4,7, 9,8, 13,9, 36,
     * <p>
     * 2,4,3,5,4,7,9,8,13,9,36,
     * 2,3,4,5,4,7,9,8,13,9,36,
     * 2,3,4,4,5,7,9,8,13,9,36,
     * 2,3,4,4,5,7,8,9,13,9,36,
     * 2,3,4,4,5,7,8,9,9,13,36,
     *
     * @param array
     * @return
     */


    static int[] shellSort2(int[] array) {
        customPrint(array);
        System.out.println("----------------------");
        for (int i = array.length / 2; i >= 1; i = i / 2) {
            for (int j = 0; j < i; j++) { //几组
                for (int k = j + i; k < array.length; k += i) { //组内数据
                    int index = k;
                    while (index - i >= 0 && array[index - i] > array[index]) { // 分别和前面的数据比较
                        int temp = array[index - i];
                        array[index - i] = array[index];
                        array[index] = temp;
                        index -= i;
                        customPrint(array);
                    }
                }
            }
        }
        return array;
    }

    private static void customPrint(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


    static void shellSort3(int[] array) {
        //
        for (int i = array.length / 2; i >= 1; i /= 2) { // 分组
            for (int j = 0; j < i; j++) { // 组内个数
                for (int k = 0; k < array.length; k += i) {           //需要比较的上一索引
                    for (int l = k + i; l < array.length; l += i) {   //需要比较的下一个索引
                        if (array[k] > array[l]) {
                            int tmp = array[k];
                            array[k] = array[l];
                            array[l] = tmp;
                        }
                    }
                }
            }
        }
    }

}
