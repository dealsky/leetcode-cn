package _053最大子序和;

// https://leetcode-cn.com/problems/maximum-subarray/description/

import java.util.Arrays;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }

        return max;
    }

    // 更为精妙的分治法
    public int maxSubArray2(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        int mid = len / 2;

        int leftMax = maxSubArray2(Arrays.copyOfRange(nums, 0, mid));
        int rightMax = maxSubArray2(Arrays.copyOfRange(nums, mid, len));

        int midLeftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid - 1; i >= 0; i--) {
            sum += nums[i];

            midLeftMax = Math.max(sum, midLeftMax);
        }

        int midRightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid; i < len; i++) {
            sum += nums[i];

            midRightMax = Math.max(sum, midRightMax);
        }

        return Math.max(Math.max(leftMax, rightMax), midLeftMax + midRightMax);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{1};

        System.out.println(solution.maxSubArray2(arr));
    }
}
