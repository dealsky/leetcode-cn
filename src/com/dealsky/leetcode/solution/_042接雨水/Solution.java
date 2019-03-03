package com.dealsky.leetcode.solution._042接雨水;

public class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }

        int top = height[0];
        for (int i = 1; i < length; i++) {
            top = Math.max(top, height[i]);
        }

        int left = 0, right = length - 1;
        int lH = 0, rH = 0, result = 0;

        while (height[left] != top || height[right] != top) {
            if (height[left] < top) {
                lH = Math.max(lH, height[left]);
                result += (lH - height[left]);
                left++;
            }

            if (height[right] < top) {
                rH = Math.max(rH, height[right]);
                result += (rH - height[right]);
                right--;
            }
        }

        for (int i = left + 1; i < right; i++) {
            result += (top - height[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
    }
}
