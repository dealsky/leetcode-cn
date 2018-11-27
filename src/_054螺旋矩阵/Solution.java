package _054螺旋矩阵;

// https://leetcode-cn.com/problems/spiral-matrix/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        int size = n * m;
        m--;

        List<Integer> result = new ArrayList<>();

        int i = 0, j = -1;
        while ((n != 0 || m != 0) && result.size() != size) {

            for (int count = 0; count < 4; count++) {
                int len = (count & 1) == 0 ? n : m;
                for (int temp = 0; temp < len; temp++) {
                    i += direction[count][0];
                    j += direction[count][1];
                    result.add(matrix[i][j]);
                }

                if ((count & 1) == 0) {
                    n--;
                } else {
                    m--;
                }

                if (n == 0 && m == 0 || result.size() == size) {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
