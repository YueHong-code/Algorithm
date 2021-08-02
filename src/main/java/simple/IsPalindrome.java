/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;


import org.joda.time.DateTime;

import java.util.Date;

/** 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
 *
 * 输入：x = 121
 * 输出：true
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 思路：将整数转成数组  进行比较
 * @author huangyuehong01
 * @since 2021-07-27
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {

        if (x < 0 ) {
            return false;
        }

        int[] a = new int[50];
        int i = 0;
        while (x != 0) {
            a[i++] = x%10;
            x = x/10;
        }

        for (int j = 0 ; j < i/2 ; j ++) {
            if (a[j] != a [i - 1 - j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();


        String currentTimeStr = new DateTime(new Date()).toString("yyyyMMddHHmmssSSS");
        currentTimeStr = String.format("%010", currentTimeStr);
        System.out.println(currentTimeStr);

        boolean is = isPalindrome.isPalindrome(-1221);
        System.out.println(is);

    }
}
