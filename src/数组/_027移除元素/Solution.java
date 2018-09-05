package 数组._027移除元素;

// https://leetcode-cn.com/problems/remove-element/description/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }

        return len;
    }
}
