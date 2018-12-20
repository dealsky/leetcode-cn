package com.dealsky.leetcode.solution._166分数到小数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dealsky
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        int symbol1 = numerator > 0 ? 1 : 0;
        int symbol2 = denominator > 0 ? 1 : 0;
        boolean flag = (symbol1 ^ symbol2) == 1;

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        StringBuilder left = new StringBuilder("0");
        if (num >= den) {
            if (num % den == 0) {
                return flag ? "-" + String.valueOf(num / den) : String.valueOf(num / den);
            }

            left = new StringBuilder(String.valueOf(num / den));
            num %= den;
        }

        left.append(".");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; num < den; i++) {
            num *= 10;
            if (i > 0) {
                left.append("0");
            }
        }

        Map<Long, Integer> map = new HashMap<>();
        int offset = 0;
        map.put(num, offset);

        long temp = num;
        int zeroLength = 0;
        while (true) {
            builder.append(temp / den);
            long remainder = temp % den;

            if (remainder == 0) {
                return flag ? "-" + left.append(builder).toString() : left.append(builder).toString();
            }

            remainder *= 10;
            StringBuilder builder1 = new StringBuilder();
            while (remainder < den) {
                remainder *= 10;
                builder1.append("0");
            }

            if (map.containsKey(remainder)) {
                zeroLength = builder1.length();
                offset = map.get(remainder);
                break;
            } else {
                map.put(remainder, ++offset);
            }

            temp = remainder;
            builder.append(builder1);
        }

        if (offset == 0) {
            left.insert(left.length() - zeroLength, "(");
        } else {
            builder.insert(offset, "(");
        }

        if (flag) {
            left.insert(0, "-");
        }
        return left.append(builder).append(")").toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fractionToDecimal(-1, -2147483648));
    }
}
