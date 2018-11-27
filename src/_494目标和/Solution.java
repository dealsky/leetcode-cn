package _494目标和;

// https://leetcode-cn.com/problems/target-sum/description/

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S, 0);
    }

    private int dfs(int[] nums, int index, int target, int result) {
        if (index == nums.length) {
            if (target == 0) {
                result++;
            }
            return result;
        }

        result = dfs(nums, index + 1, target + nums[index], result);
        result = dfs(nums, index + 1, target - nums[index], result);

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
