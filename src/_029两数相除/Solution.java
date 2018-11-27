package _029两数相除;

// https://leetcode-cn.com/problems/divide-two-integers/description/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) {
            return Integer.MAX_VALUE;
        }

        int neg1 = dividend < 0 ? 1 : 0;
        int neg2 = divisor < 0 ? 1 : 0;
        boolean symbol = (neg1 ^ neg2) == 0;

        long left = Math.abs((long) dividend);
        long right = Math.abs((long) divisor);

        if (left == 0 || left < right) {
            return 0;
        }

        int result = 0;
        while (left >= right) {
            long temp = right;
            long count = 1L;

            while (left >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            left -= temp;
            result += count;
        }

        return symbol ? result : -result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
    }
}
