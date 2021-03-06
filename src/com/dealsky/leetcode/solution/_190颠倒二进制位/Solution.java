package com.dealsky.leetcode.solution._190颠倒二进制位;

public class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result = (result << 1) + 1;
            } else {
                result = result << 1;
            }

            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

         System.out.println(solution.reverseBits(2));
    }
}
