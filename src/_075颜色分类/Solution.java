package _075颜色分类;

// https://leetcode-cn.com/problems/sort-colors/description/

public class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;

        while (cur <= right) {
            if (nums[cur] == 0) {
                while (nums[left] == 0 && left < cur) {
                    left++;
                }

                swap(nums, left++, cur);
            }

            if (nums[cur] == 2) {
                while (nums[right] == 2 && cur < right) {
                    right--;
                }

                swap(nums, cur, right--);
                if (nums[cur] == 0) {
                    swap(nums, left++, cur);
                }
            }

            cur++;
        }
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

        int[] arr = new int[]{2,2, 1, 0, 2, 1, 1, 0, 2, 0, 1, 0, 1, 0, 2, 1, 0, 1, 1, 0, 2, 1, 0, 2, 1, 1, 0};
        solution.sortColors(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}
