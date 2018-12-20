package com.dealsky.leetcode.solution._485最大连续1的个数;

// https://leetcode-cn.com/problems/max-consecutive-ones/description/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;

        for (int num : nums) {
            if (num == 1) {
                sum++;
            } else {
                max = Math.max(max, sum);
                sum = 0;
            }
        }

        return max == 0 || sum > max ? sum : max;
    }
}
