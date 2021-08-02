/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package difficult;



/**
 * K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 模拟算法
 *
 * 你的思路是对的 但是对于链表本身可能了解还需深入
 *
 * @author huangyuehong01
 * @since 2021-07-19
 */

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode hair = new ListNode(0);
        hair.next = head; // 虚拟了一个节点hair
        ListNode pre = hair;

        while (head != null) {
            // 先保存下一个节点
            ListNode tail = pre;

            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] nodes = myReverse(head, tail);
            head = nodes[0];
            tail = nodes[1];

            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;

        }
        return hair.next;

    }



    public ListNode[] myReverse(ListNode head, ListNode tail) {
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

    ListNode revert(ListNode head) {
        ListNode curr = head;

        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseKGroup r = new ReverseKGroup();
        r.reverseKGroup(head, 2);

    }

}
