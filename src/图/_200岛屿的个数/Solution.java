package 图._200岛屿的个数;

// https://leetcode-cn.com/problems/number-of-islands/description/

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
        if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.numIslands(new char[10][10]);
    }
}
