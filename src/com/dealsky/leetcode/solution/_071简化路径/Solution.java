package com.dealsky.leetcode.solution._071简化路径;

// https://leetcode-cn.com/problems/simplify-path/

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String str : arr) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }

            if (str.equals("..")) {
                if (deque.size() > 0) {
                    deque.removeFirst();
                }
            } else {
                deque.addFirst(str);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append("/").append(deque.removeLast());
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
    }
}
