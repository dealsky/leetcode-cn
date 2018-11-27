package _498对角线遍历;

// https://leetcode-cn.com/problems/diagonal-traverse/description/

import java.util.Arrays;

public class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;

        boolean flag = true;
        int[] result = new int[n * m];
        int len = 0;

        for (int i = 0, j = 0; len < n * m; len++) {
            result[len] = matrix[i][j];
            if (flag) {
                if (i != 0 && j != n - 1) {
                    i--;
                    j++;
                } else if (i == 0 && j != n - 1) {
                    j++;
                    flag = false;
                } else {
                    i++;
                    flag = false;
                }
            } else {
                if (i != m - 1 && j != 0) {
                    i++;
                    j--;
                } else if (j == 0 && i != m - 1) {
                    i++;
                    flag = true;
                } else {
                    j++;
                    flag = true;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findDiagonalOrder(new int[][]{{1, 1}, {2, 2}})));
    }
}
