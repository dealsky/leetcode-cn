package _557反转字符串中的单词3;

// https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/

public class Solution {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i != 0) {
                builder.append(" ");
            }
            builder.append(reverse(strings[i]));
        }
        return builder.toString();
    }

    private char[] reverse(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
