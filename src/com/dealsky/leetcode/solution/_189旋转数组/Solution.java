package com.dealsky.leetcode.solution._189旋转数组;

// https://leetcode-cn.com/problems/rotate-array/description/

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int middle = len - k % len - 1;

        reverse(nums, 0, middle);
        reverse(nums, middle + 1, len - 1);
        reverse(nums, 0, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(nums, 4);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
