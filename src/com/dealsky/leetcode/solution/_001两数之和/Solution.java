package com.dealsky.leetcode.solution._001两数之和;

// https://leetcode-cn.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};

        Solution solution = new Solution();
        for (int num : solution.twoSum(nums, 6)) {
            System.out.println(num);
        }
    }
}
