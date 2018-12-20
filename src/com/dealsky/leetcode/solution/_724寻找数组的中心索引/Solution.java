package com.dealsky.leetcode.solution._724寻找数组的中心索引;

// https://leetcode-cn.com/problems/find-pivot-index/description/

public class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - nums[i] -left) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}
