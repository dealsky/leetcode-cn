package com.dealsky.leetcode.solution._283移动零;

// https://leetcode-cn.com/problems/move-zeroes/description/

public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};

        Solution solution = new Solution();
        solution.moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
