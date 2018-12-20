package com.dealsky.leetcode.solution._067二进制求和;

// https://leetcode-cn.com/problems/add-binary/description/

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();

        int index = 0, temp = 0;
        while (index < a.length() || index < b.length()) {
            int sum = 0;

            if (index < a.length()) {
                sum += a.charAt(a.length() - index - 1) - '0';
            }

            if (index < b.length()) {
                sum += b.charAt(b.length() - index - 1) - '0';
            }

            sum += temp;
            temp = 0;
            builder.insert(0, sum % 2);
            if (sum >= 2) {
                temp = 1;
            }

            index++;
        }

        if (temp == 1) {
            builder.insert(0, 1);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("1", "11"));
    }

}
