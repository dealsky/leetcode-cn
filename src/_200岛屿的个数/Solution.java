package _200岛屿的个数;

// https://leetcode-cn.com/problems/number-of-islands/description/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;

        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    dfs(grid, i, j);
                }
            }
        }

        return sum;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
    }

    private static final int[][] position = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands2(char[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    bfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] crt = queue.poll();
            x = crt[0];
            y = crt[1];

            for (int[] arr : position) {
                int offsetX = x + arr[0];
                int offsetY = y + arr[1];
                if (offsetX < 0 || offsetX >= grid.length || offsetY < 0 || offsetY >= grid[0].length) {
                    continue;
                }

                if (grid[offsetX][offsetY] == '1') {
                    grid[offsetX][offsetY] = '0';
                    queue.offer(new int[]{offsetX, offsetY});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.numIslands2(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '1'}
        });
        System.out.println(result);
    }
}
