package com.dealsky.leetcode.solution._567字符串的排列;

// https://leetcode-cn.com/problems/permutation-in-string/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character character : s1.toCharArray()) {
            if (map1.containsKey(character)) {
                map1.put(character, map1.get(character) + 1);
            } else {
                map1.put(character, 1);
            }
        }

        for (Character character : s2.substring(0, len1).toCharArray()) {
            if (map2.containsKey(character)) {
                map2.put(character, map2.get(character) + 1);
            } else {
                map2.put(character, 1);
            }
        }

        if (map1.equals(map2)) {
            return true;
        }

        for (int i = 0; i < len2 - len1; i++) {
            char prefix = s2.charAt(i);
            char suffix = s2.charAt(i + len1);
            if (map2.get(prefix) == 1) {
                map2.remove(prefix);
            } else {
                map2.put(prefix, map2.get(prefix) - 1);
            }
            if (map2.containsKey(suffix)) {
                map2.put(suffix, map2.get(suffix) + 1);
            } else {
                map2.put(suffix, 1);
            }
            if (map1.equals(map2)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2)) {
            return true;
        }

        for (int i = 0; i < len2 - len1; i++) {
            char prefix = s2.charAt(i);
            char suffix = s2.charAt(i + len1);
            arr2[prefix - 'a']--;
            arr2[suffix - 'a']++;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion2("ab", "eidbaoo"));
    }
}
