/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */


import java.util.HashSet;
import java.util.Set;

/**
 * @author huangyuehong01
 * @since 2021-06-29
 */
class Solution {
    /**
     * 两数相加
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0 ; i< nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0]=i;
                    res[1] =j;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 什么时候初始化下一个节点？需要赋值的时候
     *
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode head = null;
       ListNode next = null;
       int b = 0;
       while (l1 != null || l2 != null) {
           int v1 = 0;
           int v2 =0;
           if (l1 != null) {
               v1 = l1.val ;
               l1 = l1.next;
           }
           if (l2 != null) {
               v2 = l2.val;
               l2 = l2.next;
           }
           int a = (v1 + v2 + b) %10;
           b = (v1 + v2 + b) / 10;

           if (head == null) {
               head = next = new ListNode(a);
           } else {
               next.next = new ListNode(a);
               next = next.next;
           }
       }

       if (b > 0) {
           next.next = new ListNode(b);

       }

        return head;

    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: s = "abcabcbb"
     * 输出: 3
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        int len = s.length();
        Set<String> set = new HashSet<String>();
        for (int i = len - 1; i > 1 ; i++) {
            // i是滑动窗口大小
            for (int j = 0 ; j  < len; j++) {
                int wlen = (i + j) >= len ? len : (i );
                String ss = s.substring(j, wlen);

            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }

}
