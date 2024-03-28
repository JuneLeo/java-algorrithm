package com.algorithm.sample.leetcode;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class NodeListAlg {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode tmp = listNode;

        while (l1 != null && l2 != null) {
            tmp.val = tmp.val + l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            if (tmp.val > 9 || l1 != null || l2 != null) {
                ListNode next = new ListNode();
                if (tmp.val > 9) {
                    tmp.val = tmp.val % 10;
                    next.val = 1;
                }
                tmp.next = next;
                tmp = tmp.next;

            }
        }
        ListNode tmp2 = null;
        if (l1 != null) {
            tmp2 = l1;
        } else if (l2 != null) {
            tmp2 = l2;
        }

        while (tmp2 != null) {
            tmp.val = tmp.val + tmp2.val;
            tmp2 = tmp2.next;
            if (tmp.val > 9 || (tmp2 != null)) {
                ListNode next = new ListNode();
                if (tmp.val > 9) {
                    tmp.val = tmp.val % 10;
                    next.val = 1;
                }
                tmp.next = next;
                tmp = tmp.next;

            }
        }

        return listNode;
    }


///////////////////////////////////////////
// 两个大于0的整数倒序放入单链表中，求和
///////////////////////////////////////////
//    public static void main(String[] args) {
//        ListNode threeNode = new ListNode(3);
//        ListNode forNode = new ListNode(4, threeNode);
////        ListNode twoNode = new ListNode(2, forNode);
//
//        ListNode fourNode = new ListNode(4);
//        ListNode sixNode = new ListNode(6, fourNode);
//        ListNode fiveNode = new ListNode(5, sixNode);
//
//        ListNode listNode = addTwoNumbers(forNode, fiveNode);
//
//// [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//        // [4,3], l2 = [5,6,4]
//        // 34+465 = 499
//        // 994
//
////        ListNode nine6 = new ListNode(9);
////        ListNode nine5 = new ListNode(9,nine6);
////        ListNode nine4 = new ListNode(9,nine5);
////        ListNode nine3 = new ListNode(9,nine4);
////        ListNode nine2 = new ListNode(9,nine3);
////        ListNode nine1 = new ListNode(9,nine2);
////        ListNode nine = new ListNode(9,nine1);
////
////
////        ListNode nine10 = new ListNode(9);
////        ListNode nine11 = new ListNode(9,nine10);
////        ListNode nine12 = new ListNode(9,nine11);
////        ListNode nine13 = new ListNode(9,nine12);
////
////        // 9999999 + 9999
////
////        ListNode listNode = addTwoNumbers(nine, nine13);
//
//        while (listNode != null) {
//            System.out.print(listNode.val);
//            listNode = listNode.next;
//        }

//    }

    ///////////////////////////////////////////
// 删除链表的倒数第 N 个结点
///////////////////////////////////////////
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
//        System.out.println(length);

        current = head;
        int index = length - n;

        if (index == 0) {
            return head.next;
        }

        while (current != null) {
            index--;
            if (index == 0) {
                // 删除下一个节点
//                System.out.println(current.val);
                if (current.next != null) {
                    current.next = current.next.next;
                }
                break;
            }
            current = current.next;
        }


        return head;
    }

//    public static void main(String[] args) {
//        ListNode nine6 = new ListNode(7);
//        ListNode nine5 = new ListNode(6, nine6);
//        ListNode nine4 = new ListNode(5, nine5);
//        ListNode nine3 = new ListNode(4, nine4);
//        ListNode nine2 = new ListNode(3, nine3);
//        ListNode nine1 = new ListNode(2, nine2);
//        ListNode nine = new ListNode(1, nine1);
//        ListNode listNode = removeNthFromEnd(nine, 7);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
//    }

    //
    // 合并两个有序链表
    //
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            // 1 6 9,12
            // 2,7,8
            //

            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode pre = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        if (list1 != null) {
            pre.next = list1;
        } else if (list2 != null) {
            pre.next = list2;
        }

        return result.next;
    }


//    public static void main(String[] args) {
//        ListNode nine6 = new ListNode(16);
//        ListNode nine5 = new ListNode(10, nine6);
//        ListNode nine4 = new ListNode(8, nine5);
//        ListNode nine3 = new ListNode(6, nine4);
//        ListNode nine2 = new ListNode(4, nine3);
//        ListNode nine1 = new ListNode(2, nine2);
//        ListNode nine = new ListNode(1, nine1);
//
//
//        ListNode other7 = new ListNode(18);
//        ListNode other6 = new ListNode(16, other7);
//        ListNode other5 = new ListNode(14, other6);
//        ListNode other4 = new ListNode(12, other5);
//        ListNode other3 = new ListNode(9, other4);
//        ListNode other2 = new ListNode(6, other3);
//        ListNode other = new ListNode(3, other2);
//        mergeTwoLists2(nine, other);
//    }

    //
    // 并 K 个升序链表
    //
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode first = lists[0];
        for (int i = 1; i < lists.length; i++) {
            first = merge2Lists(first, lists[i]);
        }
        return first;
    }

    private static ListNode merge2Lists(ListNode first, ListNode second) {
        ListNode head = new ListNode();
        ListNode pre = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }

        if (first != null) {
            pre.next = first;
        } else {
            pre.next = second;
        }

        return head.next;
    }


//    public static void main(String[] args) {
//        ListNode nine6 = new ListNode(16);
//        ListNode nine5 = new ListNode(10, nine6);
//        ListNode nine4 = new ListNode(8, nine5);
//        ListNode nine3 = new ListNode(6, nine4);
//        ListNode nine2 = new ListNode(4, nine3);
//        ListNode nine1 = new ListNode(2, nine2);
//        ListNode nine = new ListNode(1, nine1);
//
//
//        ListNode other7 = new ListNode(18);
//        ListNode other6 = new ListNode(16, other7);
//        ListNode other5 = new ListNode(14, other6);
//        ListNode other4 = new ListNode(12, other5);
//        ListNode other3 = new ListNode(9, other4);
//        ListNode other2 = new ListNode(6, other3);
//        ListNode other = new ListNode(3, other2);
//
//        ListNode three7 = new ListNode(20);
//        ListNode three6 = new ListNode(17, three7);
//        ListNode three5 = new ListNode(15, three6);
//        ListNode three4 = new ListNode(9, three5);
//        ListNode three3 = new ListNode(5, three4);
//        ListNode three2 = new ListNode(3, three3);
//        ListNode three = new ListNode(1, three2);
//
//        ListNode[] listNodes = new ListNode[]{nine, other, three};
//        ListNode listNode = mergeKLists(listNodes);
//        while (listNode != null) {
//            System.out.print(listNode.val);
//            listNode = listNode.next;
//        }
//    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1,2,4,5,6
        //
        ListNode newHead = head.next; //newHead = 2
        head.next = swapPairs(newHead.next); // 1.next =
        newHead.next = head; //2.next = 1;
        return newHead;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode current = result;
        // 0 , 1, 3, 5
        // 1和3交换，0.next =
        while (current.next != null && current.next.next != null) {
            ListNode next = current.next; // 1
            ListNode nextNext = current.next.next; //3
            current.next = nextNext; // 0.next -> 3
            next.next = nextNext.next; //1.next -> 5
            nextNext.next = next;      // 3.next -> 1
            current = next;
        }
        return result.next;
    }

//    public static void main(String[] args) {
//        ListNode three7 = new ListNode(20);
//        ListNode three6 = new ListNode(17, three7);
//        ListNode three5 = new ListNode(15, three6);
//        ListNode three4 = new ListNode(9, three5);
//        ListNode three3 = new ListNode(5, three4);
//        ListNode three2 = new ListNode(3, three3);
//        ListNode three = new ListNode(1, three2);
//
//        ListNode listNode = swapPairs2(three);
//        while (listNode != null) {
//            System.out.print(listNode.val + ",");
//            listNode = listNode.next;
//        }
//
//    }

    private static ListNode reverse(ListNode head) {
        ListNode per = null;
        while (head != null) {
            // 1 -> 2 -> 3 -> null
            // null <- 1 <- 2 <- 3
            ListNode next = head.next; //2
            head.next = per;  // 1.next = per
            per = head;
            head = next;
        }

        return per;
    }

//    public static void main(String[] args) {
//        ListNode three7 = new ListNode(20);
//        ListNode three6 = new ListNode(17, three7);
//        ListNode three5 = new ListNode(15, three6);
//        ListNode three4 = new ListNode(9, three5);
//        ListNode three3 = new ListNode(5, three4);
//        ListNode three2 = new ListNode(3, three3);
//        ListNode three = new ListNode(1, three2);
//
//        ListNode listNode = reverse(three);
//        while (listNode != null) {
//            System.out.print(listNode.val + ",");
//            listNode = listNode.next;
//        }
//
//    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode three7 = new ListNode(20);
        ListNode three6 = new ListNode(17, three7);
        ListNode three5 = new ListNode(15, three6);
        ListNode three4 = new ListNode(9, three5);
        ListNode three3 = new ListNode(5, three4);
        ListNode three2 = new ListNode(3, three3);
        ListNode three = new ListNode(1, three2);

        ListNode listNode = reverseKGroup(three, 3);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }

    }

}
