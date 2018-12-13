package _674最长连续递增序列;

// https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = 0, sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                sum++;
            } else {
                result = Math.max(result, sum);
                sum = 1;
            }
        }

        return Math.max(result, sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }
}
