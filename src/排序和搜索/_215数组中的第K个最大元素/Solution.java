package 排序和搜索._215数组中的第K个最大元素;

// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                }
            }
        }

        return nums[k - 1];
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {3,2,1,5,6,4};

        System.out.println(solution.findKthLargest(nums, 2));
    }
}
