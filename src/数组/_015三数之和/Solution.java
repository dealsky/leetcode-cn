package 数组._015三数之和;

// https://leetcode-cn.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (len < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{3, 0, -2, -1, 1, 2};

        System.out.println(solution.threeSum(arr));
    }
}
