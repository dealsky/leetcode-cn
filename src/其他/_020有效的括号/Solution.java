package 其他._020有效的括号;

// https://leetcode-cn.com/problems/valid-parentheses/description/


import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                if (isMatch(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean isMatch(char left, char right) {
        if (left == '(') {
            return right == ')';
        }

        if (left == '{') {
            return right == '}';
        }

        if (left == '[') {
            return right == ']';
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "{[]}";

        System.out.println(solution.isValid(str));
    }

}
