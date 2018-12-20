package com.dealsky.leetcode.solution._128最长连续序列;

// https://leetcode-cn.com/problems/longest-consecutive-sequence/

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            set.add(num);
        }

        int result = 1, max = 1;
        int pre = set.first();
        for (Integer num : set) {
            if (num == pre) {
                continue;
            }

            if (num == pre + 1) {
                max++;
                result = Math.max(result, max);
            } else {
                max = 1;
            }
            pre = num;
        }

        return result;
    }

    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : nums) {
            if (set.remove(num)) {
                int left = num - 1, right = num + 1;
                while (set.remove(left)) left--;
                while (set.remove(right)) right++;
                res = Math.max(res, right - left - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
