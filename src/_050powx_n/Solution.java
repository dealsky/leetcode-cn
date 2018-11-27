package _050powx_n;

// https://leetcode-cn.com/problems/powx-n/description/

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || Math.abs(x - 1.0D) < 1e-6) {
            return 1.0D;
        }

        if (n == Integer.MIN_VALUE) {
            return 1 / powProxy(x, Math.abs(n + 1)) / x;
        }

        return n > 0 ? powProxy(x, n) : 1 / powProxy(x, -n);
    }

    private double powProxy(double x, int n) {
        if (n == 1) {
            return x;
        }

        double num = powProxy(x, n / 2);
        if ((n & 1) == 0) {
            return num * num;
        } else {
            return num * num * x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2, 100));
    }
}
