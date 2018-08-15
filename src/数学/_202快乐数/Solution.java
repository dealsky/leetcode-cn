package 数学._202快乐数;

// https://leetcode-cn.com/problems/happy-number/description/

public class Solution {
    public boolean isHappy(int n) {
        while (n != 1) {
            if (n == 4) {
                return false;
            }
            n = sum(n);
        }

        return true;
    }

    private int sum(int n) {
        int sum = 0;

        while (n > 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isHappy(999999999));
    }
}
