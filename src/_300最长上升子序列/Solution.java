package _300最长上升子序列;

// https://leetcode-cn.com/problems/longest-increasing-subsequence/description/

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] weight = new int[len];
        Arrays.fill(weight, 1);

        int result = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    weight[i] = Math.max(weight[i], weight[j] + 1);
                }
            }

            result = Math.max(result, weight[i]);
        }

        return result;
    }

    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return len;
        }

        int current = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[current]) {
                nums[++current] = nums[i];
            } else if (nums[i] < nums[current]) {
                int index = binarySearch(nums, 0, current, nums[i]);
                nums[index] = nums[i];
            }
        }

        return current + 1;
    }

    public int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid;
            } else {
                return mid;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(solution.lengthOfLIS2(arr));
    }
}
