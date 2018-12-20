package com.dealsky.leetcode.solution._233数字1的个数;

// https://leetcode-cn.com/problems/number-of-digit-one/description/

public class Solution {
    public int countDigitOne(int n) {
        int sum = 0;

        for (long i = 1; i <= n; i *= 10) {
            long left = n / i, right = n % i;

            sum += (left + 8) / 10 * i;
            if (left % 10 == 1) {
                sum += right + 1;
            }
        }

        return sum;
    }
}
