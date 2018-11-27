package _172阶乘后的零;

// https://leetcode-cn.com/problems/factorial-trailing-zeroes/description/

/**
 * 每隔5个数都有一个数被5整除，
 * 再隔5个数会有一个数被25整除...
 */
public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.trailingZeroes(500));
    }
}
