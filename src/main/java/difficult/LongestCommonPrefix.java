/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package difficult;

/** 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author huangyuehong01
 * @since 2021-07-27
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        for (int j = 0; j < strs[0].length() ; j ++) {

            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= j || strs[i].charAt(j) != c ) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = new String[]{"ab", "a"};
        String res = l.longestCommonPrefix(strs);
        System.out.println(res);
    }

}
