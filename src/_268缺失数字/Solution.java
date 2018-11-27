package _268缺失数字;

// https://leetcode-cn.com/problems/missing-number/description/

public class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        long sum = 0;

        boolean zeroFlag = false;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }

            if (num == 0) {
                zeroFlag = true;
            }

            sum += num;
        }

        long sum2 = add(max);

        if (sum != sum2) {
            return (int)Math.abs(sum - sum2);
        } else {
            return zeroFlag ? max + 1 : 0;
        }
    }

    private long add(int n) {
        return (int)(((n + 1) / 2.0) * n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] {0, 2};

        System.out.println(solution.missingNumber(arr));
    }
}
