package 排序和搜索._240搜索二维矩阵II;

// https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }

        if (target < matrix[0][0] || target > matrix[n - 1][m - 1]) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target) {
                if (binarySearch(matrix[i], 0, m - 1, target)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
