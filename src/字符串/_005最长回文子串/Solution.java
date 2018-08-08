package 字符串._005最长回文子串;

// https://leetcode-cn.com/problems/longest-palindromic-substring/description/

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        if (len <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = doSomething(s, i, i);
            int len2 = doSomething(s, i, i + 1);
            int length = Math.max(len1, len2);

            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int doSomething(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("aaaa"));
    }
}
