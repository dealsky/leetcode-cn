package 数组._026从排序数组中删除重复项;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/

/**
 * @Author: dealsky
 * @Date: 2018/4/8 22:00
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int sum = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int preNum = nums[i - 1];
            if (num != preNum) {
                nums[sum++] = num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 6, 6, 7};

        int ans = solution.removeDuplicates(nums);
        System.out.println(ans);
    }
}
