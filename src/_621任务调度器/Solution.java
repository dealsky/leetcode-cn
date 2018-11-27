package _621任务调度器;

// https://leetcode-cn.com/problems/task-scheduler/description/

import java.util.Arrays;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        char[] arr = new char[26];

        for (char task : tasks) {
            arr[task - 'A']++;
        }

        Arrays.sort(arr);
        int same = 0;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == arr[25]) {
                same++;
            } else {
                break;
            }
        }

        return Math.max(tasks.length, (1 + n) * (arr[25] - 1) + same);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }

}
