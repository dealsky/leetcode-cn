package 排序和搜索._162寻找峰值;

// https://leetcode-cn.com/problems/find-peak-element/description/

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
