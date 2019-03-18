package com.dealsky.leetcode.solution._131分割回文串;

// https://leetcode-cn.com/problems/palindrome-partitioning/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<String>> lists;
    private List<String> temp;

    public List<List<String>> partition(String s) {
        lists = new ArrayList<>();
        temp = new ArrayList<>();
        partitionHelper(s, 0, s.length() - 1);
        return lists;
    }

    private void partitionHelper(String s, int start, int end) {
        if (start > end) {
            lists.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= end; i++) {
            String subStr = s.substring(start, i + 1);
            if (isPalindrome(subStr)) {
                temp.add(subStr);
                partitionHelper(s, i + 1, end);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }

        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
