package com.dealsky.leetcode.solution._354俄罗斯套娃信封问题;

// https://leetcode-cn.com/problems/russian-doll-envelopes/

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 1; i < n; i++) {
            int[] current = envelopes[i];
            int max = 1;
            for (int j = 0; j < i; j++) {
                int[] temp = envelopes[j];
                if (current[0] > temp[0] && current[1] > temp[1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}));
    }
}
