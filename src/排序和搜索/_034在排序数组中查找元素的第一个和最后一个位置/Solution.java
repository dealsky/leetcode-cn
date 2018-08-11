package 排序和搜索._034在排序数组中查找元素的第一个和最后一个位置;

// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;

                left = mid - 1;
                while (left >= 0 && nums[left] == target) {
                    result[0] = left;
                    left--;
                }

                right = mid + 1;
                while (right < nums.length && nums[right] == target) {
                    result[1] = right;
                    right++;
                }

                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public int[] searchRange2(int[] nums, int target) {
        int left = firstGreaterOrEqual(nums, target);

        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        int right = firstGreaterOrEqual(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    private int firstGreaterOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.searchRange2(new int[]{1}, 1)));
    }
}
