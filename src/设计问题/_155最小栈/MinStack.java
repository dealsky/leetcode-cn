package 设计问题._155最小栈;

// https://leetcode-cn.com/problems/min-stack/description/

import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minList;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minList = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minList.size() == 0 || minList.peek() >= x) {
            minList.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();

        if (num == minList.peek()) {
            minList.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
