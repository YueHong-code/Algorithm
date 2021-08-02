/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;


/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 输入: s = " "
 * 输出: 1
 *
 *
 * @author huangyuehong01
 * @since 2021-07-15
 */
public class lengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int a[];
        int max = 0;
        int c = 0;
        for (int i = 0; i < len; i++) {
            a = new int[2000];
            c =0;
            for (int j = i; j < len; j++) {
                if (a[s.charAt(j)] != 0) { // 有重复
                    if (j - i > max) {
                        max = j - i;
                    }
                    break;
                } else {
                    a[s.charAt(j)] = 1;
                    c++;
                }
            }
            if (c > max) {
                max = c;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        int a = lengthOfLongestSubstring.lengthOfLongestSubstring("erabbcddd");
        System.out.println(a);
    }

}
