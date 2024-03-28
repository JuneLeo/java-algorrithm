package com.algorithm.sample.leetcode;

public class ArrayAlg {

    ///////////////////////////////////////////
// 寻找两个数之和等于target
///////////////////////////////////////////
//
//    public static void main(String[] args) {
//        int[] a = {11, 2,3,4,15,2, 7};
//        int[] target = getTarget(a, 9);
//
//        System.out.println(target[0] + "," + target[1]);
//    }


//    public static int[] getTarget(int[] array, int target) {
//        int[] targets = new int[2];
//        for (int i = 0; i < array.length; i++) {
//            int a = array[i];
//            for (int j = i + 1; j < array.length; j++) {
//                int b = array[j];
//                if (a + b == target) {
//                    targets[0] = i;
//                    targets[1] = j;
//                    return targets;
//                }
//            }
//        }
//        return targets;
//    }


///////////////////////////////////////////
// 求两个有序数组中位数
///////////////////////////////////////////

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int current1 = 0;
        int current2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (current1 < nums1.length && current2 < nums2.length) {
                if (nums1[current1] < nums2[current2]) {
                    array[i] = nums1[current1++];
                } else {
                    array[i] = nums2[current2++];
                }
            } else if (current1 < nums1.length) {
                array[i] = nums1[current1++];
            } else {
                array[i] = nums2[current2++];
            }
        }

        if (array.length % 2 == 0) {
            int a = array.length / 2;
            return (double) (array[a] + array[a - 1]) / 2;
        } else {
            return array[array.length / 2];
        }

    }

    public static int removeDuplicates(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (index == -1 || v > nums[index]) {
                index++;
                nums[index] = v;
            }
        }
        return index + 1;
    }


//    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int length = removeDuplicates(nums);
//        for (int i = 0; i < length; i++) {
//            System.out.println(nums[i]);
//        }
//    }

    public static int removeElement(int[] nums, int val) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
            }
        }
        int gap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                gap++;
                continue;
            }
            nums[i - gap] = nums[i];
        }

        return nums.length - gap;
    }

//    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int length = removeElement(nums, 1);
//        for (int i = 0; i < length; i++) {
//            System.out.println(nums[i]);
//        }
//
//    }


    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arrays = {1, 5, 8, 5 ,9, 8, 7, 2, 1};
        nextPermutation(arrays);
    }


}
