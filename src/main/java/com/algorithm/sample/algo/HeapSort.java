package com.algorithm.sample.algo;

public class HeapSort {
    public static void main(String[] args) {
        /**
         * 堆排序
         */
        int[] heapArray = ArrayCode.ARRAY;
        long startTime = System.currentTimeMillis();
        heapArray = maxHeapSort(heapArray);
        System.out.println("heapArray time : " + (System.currentTimeMillis() - startTime));
        for (int i = 0; i < heapArray.length; i++) {
            System.out.print(heapArray[i] + ",");
        }
    }

    /**
     * 堆排序
     *
     * @param array
     * @return
     */
    static int[] maxHeapSort(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            buildMaxHeap(array, 0, i);
            swap(array, 0, i);
        }
        return array;
    }

    private static void buildMaxHeap(int[] array, int start, int end) {
        for (int i = end / 2; i >= 0; i--) {
            heaply(array, i, end);
        }
    }

    private static void heaply(int[] array, int root, int end) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left <= end && array[left] > array[root]) {
            swap(array, left, root);
            if (right <= end && array[right] > array[root]) {
                swap(array, right, root);
            }
        } else if (right <= end && array[right] > array[root]) {
            swap(array, right, root);
            if (left <= end && array[left] > array[root]) {
                swap(array, left, root);
            }
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
