package _014最长公共前缀;

// https://leetcode-cn.com/problems/longest-common-prefix/description/

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";

        int len = 1;
        while (true) {
            if (len > strs[0].length()) {
                break;
            }
            String preStr = strs[0].substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(preStr)) {
                    return result;
                }
            }
            result = preStr;
            len++;
        }

        return result;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        String str = strs[0];
        for (int len = 1; len <= str.length(); len++) {
            String prefix = str.substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    return prefix.substring(0, len - 1);
                }
            }
        }

        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings = new String[]{"flower", "flow", "flight"};

        System.out.println(solution.longestCommonPrefix2(strings));
    }
}
