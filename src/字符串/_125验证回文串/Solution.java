package 字符串._125验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if (!legal(left)) {
                start++;
                continue;
            }

            if (!legal(right)) {
                end--;
                continue;
            }

            if (!equals(left, right)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private boolean legal(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }

        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        return false;
    }

    private boolean equals(char a, char b) {
        if (a == b) {
            return true;
        }

        if (a >= 'A' && a <= 'Z' && a + 32 == b) {
            return true;
        }

        if (a >= 'a' && a <= 'z' && a - 32 == b) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "A man, a plan, a canal: Panama";

        System.out.println(solution.isPalindrome(s));
    }
}
