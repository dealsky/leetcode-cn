package com.dealsky.leetcode.solution._1016子串能表示从1到N数字的二进制串;

// https://leetcode-cn.com/problems/binary-string-with-substrings-representing-1-to-n/

/**
 * @author dealsky
 * @date 2021/6/2 下午1:37
 */
class Solution {
    public static boolean queryString(String s, int n) {
        for (int i = n / 2 + 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(queryString("11111000000111100000011110011111100000011111100000011100110011111111001001111100110011111001100", (int) 1e8));
    }

}
