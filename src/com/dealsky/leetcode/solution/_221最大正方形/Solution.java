package com.dealsky.leetcode.solution._221最大正方形;

// https://leetcode-cn.com/problems/maximal-square/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;

        int result = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        return result * result;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(arr));
    }
}
