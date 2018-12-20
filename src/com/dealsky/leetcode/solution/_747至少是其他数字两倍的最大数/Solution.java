package com.dealsky.leetcode.solution._747至少是其他数字两倍的最大数;

// https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/description/

public class Solution {
    public int dominantIndex(int[] nums) {
        boolean[] arr = new boolean[101];
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
            arr[nums[i]] = true;
        }

        for (int i = max / 2 + 1; i < max; i++) {
            if (arr[i]) {
                return -1;
            }
        }

        return index;
    }
}
