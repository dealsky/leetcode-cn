package 字符串._387字符串中的第一个唯一字符;

// https://leetcode-cn.com/problems/first-unique-character-in-a-string/description/

public class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "loveleetcode";

        System.out.println(solution.firstUniqChar(s));
    }
}
