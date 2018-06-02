package 字符串._014最长公共前缀;

// https://leetcode-cn.com/problems/longest-common-prefix/description/

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings = new String[]{"flower", "flow", "flight"};

        System.out.println(solution.longestCommonPrefix(strings));
    }
}
