package _069x的平方根;

// https://leetcode-cn.com/problems/sqrtx/description/

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x < 4) {
            return 1;
        }

        return binarySearch(2, x / 2, x);
    }

    private int binarySearch(int left, int right, long target) {
        if (left == right) {
            return left;
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if ((long) mid * mid >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left * left == target ? left : left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.mySqrt(5));
    }
}
