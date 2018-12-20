package com.dealsky.leetcode.solution._171Excel表列序号;

// https://leetcode-cn.com/problems/excel-sheet-column-number/description/

public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();

        int temp = 1;
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * temp;
            temp *= 26;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.titleToNumber("ZY"));
    }
}
