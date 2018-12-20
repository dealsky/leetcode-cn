package com.dealsky.leetcode.solution._323PowerOfThree;

// https://leetcode-cn.com/problems/power-of-three/description/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }

            n /= 3;
        }

        return true;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = Integer.MAX_VALUE; i >= 0; i--) {
            if (solution.isPowerOfThree(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
