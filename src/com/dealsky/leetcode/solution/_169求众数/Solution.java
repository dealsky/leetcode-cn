package com.dealsky.leetcode.solution._169求众数;

// https://leetcode-cn.com/problems/majority-element/description/

public class Solution {
    public int majorityElement(int[] nums) {
        int result = -1, count = 0;

        for (int num : nums) {
            if (count == 0) {
                result = num;
                count++;
            } else {
                if (num == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return result;
    }
}
