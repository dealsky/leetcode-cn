package 排序和搜索._215数组中的第K个最大元素;

// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int len = max - min + 1;
        int[] arr = new int[len];

        for (int num : nums) {
            arr[num - min]++;
        }

        for (int i = len - 1; i >= 0; i--) {
            k -= arr[i];

            if (k <= 0) {
                return i + min;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(solution.findKthLargest(nums, 4));
    }
}
