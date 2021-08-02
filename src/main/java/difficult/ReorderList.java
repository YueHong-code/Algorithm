/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package difficult;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */



/**
 * 链表相关
 * @author huangyuehong01
 * @since 2021-07-20
 */
public class ReorderList {


    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     *
     *   L0 → L1 → … → Ln-1 → Ln 
     *  请将其重新排列后变为：
     *
     *  L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
     *
     *  不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  输入: head = [1,2,3,4]
     *  输出: [1,4,2,3]
     *
     *  输入: head = [1,2,3,4,5]
     *  输出: [1,5,2,4,3]
     *
     *  方法一：可以用数组做
     *  方法二： 寻找中间节点 + 反转右半段节点 + 合并原链表与步骤二的
     * @param head
     */
    public void reorderList(ListNode head) {


        ListNode middle = middleNode(head);
        ListNode revert = reverseList(middle);

        ListNode curr = head;

        while (curr != null) {
            ListNode currNext = curr.next;
            ListNode revertNext = revert.next;

            curr.next = revert;
            revert.next = currNext;

            revert = revertNext;
            curr = currNext;
        }






    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);

        head.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;

        ReorderList r = new ReorderList();
//        r.reorderList(head);

//        r.middleNode(head);

        r.reorderList(head);

    }


    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     *
     * ：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     *
     * Tips:链表定位效果不佳 所以也可以考虑将链表 转化为数组 找到位置后 再重建链表
     *
     *
     * 一种比较新奇的方法是快慢指针
     * 我们可以继续优化方法二（我们本次实用的方法），
     * 用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。
     * 那么当 fast 到达链表的末尾时，slow 必然位于中间。
     *
     *
     */

    public ListNode middleNode(ListNode head) {

        int c = 0;
        ListNode curr = head;
        while (curr != null) {
            c++;
            curr = curr.next;
        }

        c = c/2 + 1;
        int l = 0;
        while (head != null && l < c - 1) {
            head = head.next;
            l++;
        }
        return head;

    }


    /**
     * 反转链表
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 注意这一步非常重要 否则会形成 链表闭环
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }




















}
