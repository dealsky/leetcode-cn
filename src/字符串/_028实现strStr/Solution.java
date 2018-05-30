package 字符串._028实现strStr;

public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(solution.strStr(haystack, needle));
    }
}
