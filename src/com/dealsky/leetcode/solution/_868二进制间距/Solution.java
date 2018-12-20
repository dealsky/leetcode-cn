package com.dealsky.leetcode.solution._868二进制间距;

public class Solution {
    public int binaryGap(int N) {
        char[] charArr = Integer.toBinaryString(N).toCharArray();

        int pre = -1;
        int result = 0;
        for (int i = 0; i < charArr.length; i++) {
            char current = charArr[i];

            if (current == '1' && pre == -1) {
                pre = i;
            } else if(current == '1') {
                result = Math.max(result, i - pre);
                pre = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.binaryGap(0));
    }
}
