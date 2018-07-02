package 动态规划._053最大子序和;

// https://leetcode-cn.com/problems/maximum-subarray/description/

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] {-2,-1,-3};

        System.out.println(solution.maxSubArray(arr));
    }
}
