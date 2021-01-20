package com.algorithm.sample.algo;

public class BinarySearch {
    public static void main(String[] args) {
        /**
         * 二分查找
         */
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        binarySearch(array, 10);
    }

    /**
     * 5 middle
     * 1,2,3,4  left
     * 6,7,8,9,10 right
     *
     * 2 middle
     * 1 left
     * 3,4 right
     *
     *
     * 二分查找
     *
     * @param array
     * @param key
     * @return
     */
    static int binarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (array[middle] == key) {
                return middle;
            } else if (array[middle] > key) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
}
