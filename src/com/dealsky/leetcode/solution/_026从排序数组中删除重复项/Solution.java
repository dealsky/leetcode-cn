package com.dealsky.leetcode.solution._026从排序数组中删除重复项;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/

/**
 * @Author: dealsky
 * @Date: 2018/4/8 22:00
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int sum = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int preNum = nums[i - 1];
            if (num != preNum) {
                nums[sum++] = num;
            }
        }
        return sum;
    }
}
