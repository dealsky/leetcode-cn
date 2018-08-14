package 动态规划._062不同路径;

// https://leetcode-cn.com/problems/unique-paths/description/

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }

        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.uniquePaths(1, 1));
    }
}
