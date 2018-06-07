package 数组._217存在重复元素;

// https://leetcode-cn.com/problems/contains-duplicate/description/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, true);
            }
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.add(num)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        boolean[] bools = new boolean[max - min + 1];
        for (int num : nums) {
            if (bools[num - min]) {
                return true;
            } else {
                bools[num - min] = true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate3(nums));
    }
}
