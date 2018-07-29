package 数学._013罗马数字转整数;

// https://leetcode-cn.com/problems/roman-to-integer/description/

public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        char[] charArr = s.toCharArray();

        for (int i = 0; i < len; i++) {
            char c = charArr[i];
            int num = char2int(c);

            if (i == len - 1) {
                sum += num;
            } else {
                char next = s.charAt(i + 1);

                sum += compare(c, next) < 0 ? -num : num;
            }

        }

        return sum;
    }

    private int compare(char a, char b) {
        String str = "IVXLCDM";

        return str.indexOf(a) - str.indexOf(b);
    }

    private int char2int(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
