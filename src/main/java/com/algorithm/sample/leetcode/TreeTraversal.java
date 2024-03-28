package com.algorithm.sample.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
    public static void main(String[] args) {
        /**
         *                         1
         *           2                           3
         *    4            5             6             7
         * 8     9     10     11     12     13     14     15
         */
        TreeNode TreeNode15 = new TreeNode(15, null, null);
        TreeNode TreeNode14 = new TreeNode(14, null, null);
        TreeNode TreeNode13 = new TreeNode(13, null, null);
        TreeNode TreeNode12 = new TreeNode(12, null, null);
        TreeNode TreeNode11 = new TreeNode(11, null, null);
        TreeNode TreeNode10 = new TreeNode(10, null, null);
        TreeNode TreeNode9 = new TreeNode(9, null, null);
        TreeNode TreeNode8 = new TreeNode(8, null, null);
        TreeNode TreeNode7 = new TreeNode(7, TreeNode14, TreeNode15);
        TreeNode TreeNode6 = new TreeNode(6, TreeNode12, TreeNode13);
        TreeNode TreeNode5 = new TreeNode(5, TreeNode10, TreeNode11);
        TreeNode TreeNode4 = new TreeNode(4, TreeNode8, TreeNode9);
        TreeNode TreeNode3 = new TreeNode(3, TreeNode6, TreeNode7);
        TreeNode TreeNode2 = new TreeNode(2, TreeNode4, TreeNode5);
        TreeNode TreeNode1 = new TreeNode(1, TreeNode2, TreeNode3);
//        dfs(TreeNode1);
//        bfs(TreeNode1);
//        loopTree(TreeNode1);
        // 先序遍历：1，2，4，8，9，5，10，11，3，6，12，13，7，14，15
        // 中序遍历：8，4，9，2，10，5，11，1，12，6，13，3，14，7，15
        // 后序遍历：8，9，4，10，11，5，2，12，13，6，14，15，7，3，1

        func3(TreeNode1);
    }

    /**
     * 深度优先遍历
     * @param treeNode
     */
    private static void func3(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();

            System.out.print(tree.val + "，");
            if (tree.right != null) {
                stack.push(tree.right);
            }

            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
    }

    /**
     * 层级遍历 广度优先遍历
     * @param treeNode
     */
    private static void func2(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            System.out.print(tree.val + "，");
            if (tree.left != null) {
                queue.add(tree.left);
            }

            if (tree.right != null) {
                queue.add(tree.right);
            }
        }
    }


    private static void func1(TreeNode treeNode) {

        if (treeNode.left != null) {
            func1(treeNode.left);
        }

        if (treeNode.right != null) {
            func1(treeNode.right);
        }
        System.out.print(treeNode.val + "，");
    }


    private static void loopTree(TreeNode treeNode1) {
        // 先序遍历 ①访问根结点；②先序遍历其左子树；③先序遍历其右子树。
        // 中序遍历 ①中序遍历其左子树；②访问根结点；③中序遍历其右子树。
        // 后序遍历 ①后序遍历其左子树；②后序遍历其右子树；③访问根结点。
        if (treeNode1 == null) {
            return;
        }
        if (treeNode1.left != null) {
            loopTree(treeNode1.left);
        }
        System.out.print(treeNode1.val + ",");
        if (treeNode1.right != null) {
            loopTree(treeNode1.right);
        }

    }

    private static void bfs(TreeNode treeNode1) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode1);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.print(pop.val + ",");
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
    }


    /**
     * 深度优先遍历
     *
     * @param treeNode1
     */
    private static void dfs(TreeNode treeNode1) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode1);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.val + ",");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
