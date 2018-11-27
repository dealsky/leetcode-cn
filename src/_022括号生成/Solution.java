package _022括号生成;

// https://leetcode-cn.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        if (n == 0) {
            list.add("");
            return list;
        }

        generateParenthesis(list, new StringBuilder("("), 1, n);

        return list;
    }

    public void generateParenthesis(List<String> list, StringBuilder builder, int left, int n) {
        int length = builder.length();

        if (length == n * 2) {
            list.add(builder.toString());
            return;
        }

        for (char c : new char[]{'(', ')'}) {
            if (left == 0 && c == ')') {
                continue;
            }

            if (left + length == n * 2 && c == '(') {
                continue;
            }

            builder.append(c);
            int temp = c == '(' ? 1 : -1;
            generateParenthesis(list, builder, left + temp, n);
            builder.deleteCharAt(length);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.generateParenthesis(3));
    }
}
