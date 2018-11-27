package _078子集;

// https://leetcode-cn.com/problems/subsets/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(result, new ArrayList<>(), nums, 0);

        return new ArrayList<>(result);
    }

    public void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int left) {
        result.add(new ArrayList<>(list));

        while (left++ < nums.length) {
            int num = nums[left - 1];

            list.add(num);
            subsets(result, list, nums, left);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
