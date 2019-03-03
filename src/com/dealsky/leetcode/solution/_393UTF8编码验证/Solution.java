package com.dealsky.leetcode.solution._393UTF8编码验证;

// https://leetcode-cn.com/problems/utf-8-validation/

public class Solution {
    public boolean validUtf8(int[] data) {
        if (data.length == 0) {
            return false;
        }

        int start = 0;
        while (start < data.length) {
            String first = fillZero(Integer.toBinaryString(data[start] & 255));
            if (first.charAt(0) == '0') {
                start++;
            } else {
                int n = 0;
                boolean error = true;
                for (char c : first.toCharArray()) {
                    if (c == '1') {
                        n++;
                    } else {
                        error = false;
                        break;
                    }
                }

                if (error || n == 1 || n > 4 || start + n >= data.length) {
                    return false;
                }

                for (int i = start + 1; i < start + n; i++) {
                    String str = fillZero(Integer.toBinaryString(data[i] & 255));
                    if (!str.startsWith("10")) {
                        return false;
                    }
                }

                start = start + n;
            }
        }

        return true;
    }

    private String fillZero(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8 - str.length(); i++) {
            builder.append(0);
        }

        return builder.append(str).toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validUtf8(new int[]{237}));
    }
}
