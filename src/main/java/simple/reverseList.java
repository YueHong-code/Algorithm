/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */


/** 反转链表
 * @author huangyuehong01
 * @since 2021-07-19
 */
public class reverseList {

    public ListNode reverseList(ListNode head) {

        ListNode curr = head;

        ListNode  prev = null;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        return prev;
    }

}

