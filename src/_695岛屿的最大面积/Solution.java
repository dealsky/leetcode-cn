package _695岛屿的最大面积;

// https://leetcode-cn.com/problems/max-area-of-island/

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
//                    result = Math.max(result, bfs(grid, width, height, i, j));
                    result = Math.max(result, dfs(grid, i, j, new int[]{0}));
                }
            }
        }
        return result;
    }

    private int bfs(int[][] grid, int width, int height, int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        grid[x][y] = 0;

        int sum = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int i = current[0], j = current[1];

            if (i > 0 && grid[i - 1][j] == 1) {
                setAccess(grid, queue, i - 1, j);
            }
            if (j < width - 1 && grid[i][j + 1] == 1) {
                setAccess(grid, queue, i, j + 1);
            }
            if (i < height - 1 && grid[i + 1][j] == 1) {
                setAccess(grid, queue, i + 1, j);
            }
            if (j > 0 && grid[i][j - 1] == 1) {
                setAccess(grid, queue, i, j - 1);
            }
            sum++;
        }

        return sum;
    }

    private void setAccess(int[][] grid, Queue<int[]> queue, int x, int y) {
        queue.add(new int[]{x, y});
        grid[x][y] = 0;
    }

    private int dfs(int[][] grid, int x, int y, int[] sum) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        sum[0]++;

        dfs(grid, x - 1, y, sum);
        dfs(grid, x, y + 1, sum);
        dfs(grid, x + 1, y, sum);
        dfs(grid, x, y - 1, sum);

        return sum[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
