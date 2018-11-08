package 队列和栈._739每日温度;

// https://leetcode-cn.com/problems/daily-temperatures/description/

import java.util.*;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Entity> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            Entity entity = new Entity(i, temperature);
            if (stack.isEmpty()) {
                stack.addFirst(entity);
            } else {
                if (stack.peekFirst().value >= temperature) {
                    stack.addFirst(entity);
                } else {
                    while (!stack.isEmpty() && stack.peekFirst().value < temperature) {
                        int index = stack.removeFirst().index;
                        result[index] = i - index;
                    }
                    stack.addFirst(entity);
                }
            }
        }

        return result;
    }

    private class Entity {
        int index;
        int value;

        public Entity(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
