package com.dealsky.leetcode.solution._017电话号码的字母组合;

// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();

        buildStringList(builder, digits, list);

        return list;
    }

    private void buildStringList(StringBuilder builder, String digits, List<String> list) {
        int length = builder.length();

        if (length == digits.length()) {
            list.add(builder.toString());
            return;
        }

        for (char c : Number2CharList(digits.charAt(length))) {
            builder.append(c);
            buildStringList(builder, digits, list);
            builder.deleteCharAt(length);
        }
    }

    private char[] Number2CharList(int number) {
        char[][] chars = new char[][]{
                {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };

        return chars[number - '0' - 2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.letterCombinations("234"));
    }
}
