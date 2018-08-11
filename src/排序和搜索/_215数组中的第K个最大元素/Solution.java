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

    public int findKthLargest2(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);

        return nums[nums.length - k];
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = nums[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && temp <= nums[right]) {
                right--;
            }

            while (left < right && temp >= nums[left]) {
                left++;
            }

            swap(nums, left, right);
        }

        swap(nums, start, left);

        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{-1,2,0};

        System.out.println(solution.findKthLargest2(nums, 1));
    }
}
