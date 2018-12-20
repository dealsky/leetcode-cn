package com.dealsky.leetcode.solution._033搜索旋转排序数组;

// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int min = nums[0];
        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (target < min) {
                if (nums[mid] >= min || target > nums[mid]) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] < min || nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{1, 3}, 3));
    }
}
