package com.dealsky.leetcode.solution._547朋友圈;

// https://leetcode-cn.com/problems/friend-circles/

import java.util.Arrays;

public class Solution {
    public int findCircleNum(int[][] M) {
        int length = M.length;
        if (length == 0) {
            return 0;
        }

        int[] nodes = new int[length];
        Arrays.fill(nodes, -1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    merge(nodes, i, j);
                }
            }
        }

        int res = 0;
        for (int node : nodes) {
            if (node < 0) {
                res++;
            }
        }

        return res;
    }

    private void merge(int[] arr, int a, int b) {
        a = find(arr, a);
        b = find(arr, b);
        if (a == b) {
            return;
        }

        if (arr[b] < arr[a]) {
            arr[a] = b;
            arr[b]--;
        } else {
            arr[b] = a;
            arr[a]--;
        }
    }

    private int find(int[] arr, int target) {
        if (arr[target] < 0) {
            return target;
        } else {
            return find(arr, arr[target]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{{1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}};
        System.out.println(solution.findCircleNum(arr));
    }
}
