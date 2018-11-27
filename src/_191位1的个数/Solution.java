package _191位1的个数;

// https://leetcode-cn.com/problems/number-of-1-bits/description/

public class Solution {
    public int hammingWeight(int n) {
        if (n < 0) {
            return 32 - answer(~n);
        } else {
            return answer(n);
        }
    }

    private int answer(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 2;
            n /= 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingWeight(-1));
    }
}
