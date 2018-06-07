package 数组._066加一;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        int[] result = new int[len + 1];

        digits[len - 1]++;

        for (int i = len - 1; i >= 0; i--) {
            result[i + 1] += digits[i];
            if (result[i + 1] >= 10) {
                result[i + 1] -= 10;
                result[i]++;
            }
        }

        if (result[0] != 0) {
            return result;
        } else {
            return Arrays.copyOfRange(result, 1, len + 1);
        }
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};

        Solution solution = new Solution();
        for (int num : solution.plusOne(digits)) {
            System.out.println(num);
        }
    }
}
