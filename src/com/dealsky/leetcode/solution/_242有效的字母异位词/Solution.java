package com.dealsky.leetcode.solution._242有效的字母异位词;

// https://leetcode-cn.com/problems/valid-anagram/description/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                Integer num = map.get(c);
                if (num == 1) {
                    map.remove(c);
                } else {
                    map.put(c, num - 1);
                }
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "rat";
        String t = "cat";
        System.out.println(solution.isAnagram(s, t));
    }
}
