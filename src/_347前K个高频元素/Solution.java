package _347前K个高频元素;

// https://leetcode-cn.com/problems/top-k-frequent-elements/description/

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.put(num, value + 1);
                max = Math.max(max, value + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer>[] arr = new ArrayList[max + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = max; i >= 1; i--) {
            for (Integer num : arr[i]) {
                result.add(num);

                if (result.size() == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1};

        System.out.println(solution.topKFrequent(nums, 1));
    }
}
