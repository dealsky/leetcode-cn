package _035搜索插入位置;

// https://leetcode-cn.com/problems/search-insert-position/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right--;
            } else if (nums[mid] < target) {
                left++;
            } else {
                return mid;
            }
        }

        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, 4));
    }
}
