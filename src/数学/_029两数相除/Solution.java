package 数学._029两数相除;

// https://leetcode-cn.com/problems/divide-two-integers/description/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        int neg1 = dividend > 0 ? 1 : -1;
        int neg2 = divisor > 0 ? 1 : -1;
        int symbol = neg1 == neg2 ? 1 : -1;

        if (dividend == Integer.MIN_VALUE) {
            divisor = Math.abs(divisor);

            int result = binarySearch(dividend, 1, divisor, dividend);
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend <= divisor) {
            if (dividend == divisor) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = binarySearch(1, dividend, divisor, dividend);

        return symbol == 1 ? result : -result;
    }

    private int binarySearch(int left, int right, int num, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            long temp = sum(mid, num);

            if (temp >= target) {
                if (temp == target) {
                    return left;
                } else {
                    right = mid;
                }
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    private long sum(int mid, int num) {
        long sum = 0;
        for (int i = 1; i < num; i++) {
            sum += mid;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 4);
    }
}
