package _461汉明距离;

// https://leetcode-cn.com/problems/hamming-distance/description/

public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;

        int sum = 0;
        while (n > 0) {
            sum += n % 2;
            n /= 2;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.hammingDistance(1, 4));
    }
}
