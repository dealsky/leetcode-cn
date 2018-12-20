package com.dealsky.leetcode.solution._079单词搜索;

// https://leetcode-cn.com/problems/word-search/description/

public class Solution {
    private static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }

        int x = board.length;
        if (x == 0) {
            return false;
        }
        int y = board[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, 0, i, j, new boolean[x][y])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int cur, int i, int j, boolean[][] map) {
        if (cur == word.length()) {
            return true;
        }

        int x = board.length;
        int y = board[0].length;

        if (i < 0 || i >= x || j < 0 || j >= y || map[i][j] || word.charAt(cur) != board[i][j]) {
            return false;
        }

        map[i][j] = true;
        for (int[] arr : direction) {
            if (exist(board, word, cur + 1, i + arr[0], j + arr[1], map)) {
                return true;
            }
        }
        map[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] arr = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

        System.out.println(solution.exist(arr, "ABCE"));
    }
}
