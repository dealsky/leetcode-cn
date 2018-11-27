package _198打家劫舍;

// https://leetcode-cn.com/problems/house-robber/description/

public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        int[] weight = new int[len];
        weight[len - 1] = nums[len - 1];
        weight[len - 2] = nums[len - 2];

        int result = Math.max(weight[len - 1], weight[len - 2]);
        for (int i = len - 3; i >= 0; i--) {
            int max = 0;

            for (int j = i + 2; j < len; j++) {
                max = Math.max(max, weight[j]);
            }

            weight[i] = nums[i] + max;
            result = Math.max(weight[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] {2,7,9,3,1};

        System.out.println(solution.rob(arr));
    }
}
