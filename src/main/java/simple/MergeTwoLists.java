/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;


/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 *
 * @author huangyuehong01
 * @since 2021-07-21
 */
public class MergeTwoLists {

    ListNode curr = new ListNode(0);
    ListNode head = curr;


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


       while (l1 != null || l2 != null) {

           if (l2 != null) {
               l1 = run(l1, l2.val);
           }

           if (l1 != null) {
               l2 = run(l2, l1.val);
           }

           while (l1 == null && l2 != null) {
               curr.next = l2;
               curr = curr.next;
               l2 = l2.next;
           }
           while (l2 == null && l1 != null) {
               curr.next = l1;
               curr = curr.next;
               l1 = l1.next;
           }
       }
       return head.next;
    }


    private ListNode run(ListNode l, int v) {

        while (l != null && l.val <= v) {
            curr.next = l;
            curr = l;
            l = l.next;
        }

        return l;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        ListNode l11 = new ListNode(3);

//        ListNode l12 = new ListNode(4);

        l1.next = l11;
//        l11.next = l12;


        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(7);
//        ListNode l22 = new ListNode(4);

        l2.next = l21;
//        l21.next = l22;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l = mergeTwoLists.mergeTwoLists(l1, l2);
        System.out.println(l);
    }
}
