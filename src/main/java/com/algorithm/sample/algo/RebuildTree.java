package com.algorithm.sample.algo;

import java.util.Arrays;

public class RebuildTree {
    public static void main(String[] args) {

        /**
         * 前序遍历 preorder = [3,9,20,15,7]   根-左-右
         * 中序遍历 inorder = [9,3,15,20,7]    左-根-右
         */
        int[] preArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middleArray = {4, 7, 2, 1, 5, 3, 8, 6};
        Node node = new Node();
        buildBinaryTree(preArray, middleArray, node);
    }

    private static void buildBinaryTree(int[] preArray, int[] middleArray, Node root) {
        if (preArray.length <= 0 || middleArray.length <= 0) {
            return;
        }
        root.a = preArray[0];
        int middleIndex = 0;
        while (root.a != middleArray[middleIndex]) {
            middleIndex++;
        }
        if (middleIndex > 0) {
            int[] leftMiddleArray = Arrays.copyOfRange(middleArray, 0, middleIndex);
            int[] leftPerArray = Arrays.copyOfRange(preArray, 1, middleIndex + 1);
            Node node = new Node();
            root.per = node;
            buildBinaryTree(leftPerArray, leftMiddleArray, node);
        }

        if (middleIndex < middleArray.length - 1) {
            int[] rightMiddleArray = Arrays.copyOfRange(middleArray, middleIndex + 1, middleArray.length);
            int[] rightPerArray = Arrays.copyOfRange(preArray, middleIndex + 1, middleArray.length);
            Node node = new Node();
            root.next = node;
            buildBinaryTree(rightPerArray, rightMiddleArray, node);
        }
    }

    static class Node {
        public int a;
        public Node per;
        public Node next;
    }
}
