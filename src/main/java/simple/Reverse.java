/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;


/** 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

 输入：x = 123
 输出：321

 输入：x = -123
 输出：-321

 输入：x = 120
 输出：21

 输入：x = 0
 输出：0


 tips : 注意题目中的这句话：如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0

 * @author huangyuehong01
 * @since 2021-07-26
 */
public class Reverse {
    public int reverse(int x) {

        // 放在数组里，首位判断符号
        int[] a = new int[20];
        int i = 0;
        boolean sign = x > 0 ;
        while (x != 0) {
            int c = x%10;
            a[i++] = c;
            x = x/10;
        }
        // 重新拼凑整数
        int res = 0;
        for (int j = 0 ; j < i ; j++) {
            res += a[j] * Math.pow (10, i - j - 1);
        }

        if (res >= Integer.MAX_VALUE || res <= -Integer.MAX_VALUE) {
            return 0;
        }

        return res;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int r = reverse.reverse(-1534236469);
        System.out.println(r);
    }
}
