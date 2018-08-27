package 其他._371两整数之和;

// https://leetcode-cn.com/problems/sum-of-two-integers/description/

public class Solution {
    public int getSum(int a, int b) {
        int xor = a ^ b;
        int and = (a & b) << 1;

        while (and != 0) {
            int temp = xor;
            xor = xor ^ and;
            and = (temp & and) << 1;
        }

        return xor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getSum(1, 0));
    }
}
