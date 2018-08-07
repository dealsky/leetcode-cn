package 回溯算法._046全排列;

// https://leetcode-cn.com/problems/permutations/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums);

        return result;
    }

    public void permute(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }

            list.add(num);
            permute(result, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(solution.permute(nums));
    }
}
