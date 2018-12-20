package com.dealsky.leetcode.solution._088合并两个有序数组;

// https://leetcode-cn.com/problems/merge-sorted-array/description/

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[len--] = nums1[index1--];
            } else {
                nums1[len--] = nums2[index2--];
            }
        }

        while (index1 >= 0) {
            nums1[len--] = nums1[index1--];
        }

        while (index2 >= 0) {
            nums1[len--] = nums2[index2--];
        }
    }
}
