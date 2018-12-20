package com.dealsky.leetcode.solution._350两个数组的交集2;

// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/

import java.util.Arrays;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.max(nums1.length, nums2.length) + 1];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[len++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(result, 0, len);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        Solution solution = new Solution();
        for (int num : solution.intersect(nums1, nums2)) {
            System.out.println(num);
        }
    }
}
