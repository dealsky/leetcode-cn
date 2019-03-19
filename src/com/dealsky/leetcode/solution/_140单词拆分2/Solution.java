package com.dealsky.leetcode.solution._140单词拆分2;

// https://leetcode-cn.com/problems/word-break-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private List<String> wordDict;
    private List<String> list;
    private StringBuilder builder;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        list = new ArrayList<>();
        builder = new StringBuilder();
        wordBreakHelper(s);
        return list;
    }

    private void wordBreakHelper(String s) {
        if (!wordBreak1(s)) {
            return;
        }

        int len = s.length();
        if (len == 0) {
            list.add(builder.toString());
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String temp = "";
                if (builder.length() != 0) {
                    temp = " ";
                }
                temp += word;
                builder.append(temp);
                wordBreakHelper(s.substring(word.length()));
                builder.delete(builder.length() - temp.length(), builder.length());
            }
        }
    }

    public boolean wordBreak1(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> list = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, list));
    }
}
