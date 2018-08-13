package 动态规划._055跳跃游戏;

// https://leetcode-cn.com/problems/jump-game/description/

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - 1) {
                return true;
            }

            if (max < i) {
                return false;
            }

            max = Math.max(max, i + nums[i]);
        }

        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}
