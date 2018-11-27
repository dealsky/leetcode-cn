package _008字符串转整数;

// https://leetcode-cn.com/problems/string-to-integer-atoi/description/

public class Solution {
    public int myAtoi(String str) {
        try {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    str = str.substring(i);
                    break;
                }
            }

            int neg = 1;
            char firstWord = str.charAt(0);
            if (firstWord == '+') {
                str = str.substring(1);
            } else if (firstWord == '-') {
                str = str.substring(1);
                neg = -1;
            } else if (!(firstWord >= '0' && firstWord <= '9')) {
                return 0;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    str = str.substring(i);
                    break;
                }
            }
            if (str.charAt(0) == '0') {
                return 0;
            }

            String numStr = "";
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!(c >= '0' && c <= '9')) {
                    numStr = str.substring(0, i);
                    flag = true;
                    break;
                }
                if (i == 11) {
                    if (neg == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            if (!flag) {
                numStr = str;
            }

            if (numStr.length() > 10) {
                if (neg == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            Long num = Long.valueOf(numStr) * neg;
            if (num > 0 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (num < 0 && num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return num.intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "42";
        System.out.println(solution.myAtoi(str));
    }
}
