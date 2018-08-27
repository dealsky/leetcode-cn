package 其他._150逆波兰表达式求值;

// https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/description/

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String token : tokens) {
            if (isNum(token)) {
                deque.addFirst(Integer.valueOf(token));
            } else {
                Integer right = deque.removeFirst();
                Integer left = deque.removeFirst();

                switch (token) {
                    case "+":
                        deque.addFirst(left + right);
                        break;
                    case "-":
                        deque.addFirst(left - right);
                        break;
                    case "*":
                        deque.addFirst(left * right);
                        break;
                    case "/":
                        deque.addFirst(left / right);
                        break;
                }
            }
        }

        return deque.removeFirst();
    }

    private boolean isNum(String str) {
        return !str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/");
    }
}
