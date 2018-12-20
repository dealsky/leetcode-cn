package com.dealsky.leetcode.solution._003无重复字符的最长子串;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 1;

        int max = Integer.MIN_VALUE;

        char[] arr = s.toCharArray();
        while (right < arr.length) {
            for (int i = left; i <= right - 1; i++) {
                if (arr[i] == arr[right]) {
                    left = i + 1;
                }
            }

            max = Math.max(right - left + 1, max);

            right++;
        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int left = 0;
        int right = 0;

        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        while (right < len) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }

        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < len; right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }

            max = Math.max(max, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }

        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        int result = Integer.MIN_VALUE;
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        for (int left = 0, right = 0; right < len; right++) {
            char current = s.charAt(right);
            if (arr[current] != -1) {
                left = Math.max(left, arr[current] + 1);
            }
            result = Math.max(result, right - left + 1);
            arr[current] = right;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring4("abba"));
    }
}
