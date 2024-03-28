package com.algorithm.sample.algo;

public class NodeRevert {
    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node root = new Node(1, node2);

        Node temp = root;
        while (temp != null) {
            System.out.print(temp.a + ",");
            temp = temp.next;
        }
        /**
         * 单链表反转
         */
        temp = revertNode2(root);

        while (temp != null) {
            System.out.print(temp.a + ",");
            temp = temp.next;
        }
    }


    public static Node revertNode2(Node node) {
        Node per = null;
        while (node != null) {
            Node next = node.next;
            node.next = per;
            per = node;
            node = next;
        }
        return per;
    }


    /**
     * 反转单链表
     *
     * @param node
     * @return
     */
    public static Node revertNode(Node node) {
        Node per = null;
        while (node != null) {
            Node next = node.next;
            node.next = per;
            per = node;
            node = next;
        }
        return per;
    }

    static class Node {
        public Node(int a, Node next) {
            this.a = a;
            this.next = next;
        }

        public int a;
        public Node next;
    }
}
