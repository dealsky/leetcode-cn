package _043字符串相乘;

// https://leetcode-cn.com/problems/multiply-strings/

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length();
        int[] arr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = len1 + len2 - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }

        StringBuilder builder = new StringBuilder();
        int start = 0;
        while (arr[start] == 0) {
            start++;
        }
        for (int i = start; i < len1 + len2; i++) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
    }
}
