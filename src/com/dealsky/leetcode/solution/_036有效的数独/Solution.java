package com.dealsky.leetcode.solution._036有效的数独;

// https://leetcode-cn.com/problems/valid-sudoku/description/

import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet set1 = new HashSet();
            HashSet set2 = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!set1.add(board[i][j])) {
                    return false;
                }
            }

            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }

                if (!set2.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet set = new HashSet();
                for (int k = i; k < i + 3; k++) {
                    for (int g = j; g < j + 3; g++) {
                        if (board[k][g] == '.') {
                            continue;
                        }

                        if (!set.add(board[k][g])) {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }
}
