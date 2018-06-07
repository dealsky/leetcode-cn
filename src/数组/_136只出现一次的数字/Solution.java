package 数组._136只出现一次的数字;

// https://leetcode-cn.com/problems/single-number/description/

import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, value + 1);
            } else {
                map.put(num, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.iterator().next();
    }

    public int singleNumber3(int[] nums) {
        int flag = 0;

        for (int num : nums) {
            flag ^= num;
        }

        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 1, 2, 1, 2};

        System.out.println(solution.singleNumber3(nums));
    }
}
