package 字符串._344反转字符串;

// https://leetcode-cn.com/problems/reverse-string/description/

public class Solution {
    public String reverseString(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    public String reverseString2(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseString("hello"));
    }
}
