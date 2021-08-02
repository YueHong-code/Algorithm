/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */
package simple;

/**寻找两个正序数组的中位数
 * @author huangyuehong01
 * @since 2021-07-15
 *
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 *
 */
public class findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j =0, z=0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] num = new int[len1 + len2 + 1 ];

        while (i < len1 || j < len2) {

            if (i < len1 && j < len2) {
                if (nums1[i] < nums2[j]) {
                    num[z++] = nums1[i++];
                } else {
                    num[z++] = nums2[j++];
                }
            }

            if (i == len1 && j < len2) {
                num[z++] = nums2[j++];
            }

            if (j == len2 && i< len1) {
                num[z++] = nums1[i++];
            }
        }


        if (z%2 == 0) {
            double r = (num[z/2] + num[z/2 -1])/2.0;
             return r;
        } else {
            return num[(z/2 + 1)-1];
        }

    }

    public static void main(String[] args) {
        findMedianSortedArrays f = new findMedianSortedArrays();
        int[]  nums1 = {2};
        int[] nums2 = {};
        double r = f.findMedianSortedArrays(nums1, nums2);
        System.out.println(r);

    }
}
