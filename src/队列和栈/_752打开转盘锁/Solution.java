package 队列和栈._752打开转盘锁;

// https://leetcode-cn.com/problems/open-the-lock/description/

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("0000");
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) {
            return -1;
        }

        int result = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int j = 0; j < size; j++) {
                String current = deque.removeFirst();
                if (current.equals(target)) {
                    return result;
                }

                for (int i = 0; i < 4; i++) {
                    char[] chars = current.toCharArray();
                    chars[i] = (char) ((chars[i] - '0' + 1) % 10 + '0');
                    String str = new String(chars);
                    if (!set.contains(str)) {
                        deque.addLast(str);
                        set.add(str);
                    }
                    chars[i] = (char) ((chars[i] - '0' + 8) % 10 + '0');
                    str = new String(chars);
                    if (!set.contains(str)) {
                        deque.addLast(str);
                        set.add(str);
                    }
                }
            }

            result++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.openLock(new String[]{"1301", "0113", "0202", "0122", "3012", "0131", "0200", "0203", "1232", "0222"}, "2311"));
    }
}
