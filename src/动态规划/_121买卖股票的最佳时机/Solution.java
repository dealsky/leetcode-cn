package 动态规划._121买卖股票的最佳时机;

// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                if (price - min > max) {
                    max = price - min;
                }
            }
        }

        return max > 0 ? max : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] {7,6,4,3,1};

        System.out.println(solution.maxProfit(arr));
    }
}
