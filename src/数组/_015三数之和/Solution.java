package 数组._015三数之和;

// https://leetcode-cn.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 1; i < len - 1; i++) {
            int pre = i - 1;
            int suf = i + 1;

            while (pre >= 0 && suf < len) {
                if (nums[pre] > 0) {
                    pre--;
                    continue;
                }

                int sum = nums[i] + nums[pre] + nums[suf];

                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[pre], nums[i], nums[suf]);

                    if (result.size() == 0) {
                        result.add(list);
                    } else {
                        if (checkList(result, list)) {
                            result.add(list);
                        }
                    }

                    pre--;
                    suf++;
                } else if (sum > 0) {
                    pre--;
                } else {
                    suf++;
                }
            }
        }

        return result;
    }

    private boolean checkList(List<List<Integer>> result, List list) {
        for (List current : result) {
            if (current.get(0).equals(list.get(0)) && current.get(1).equals(list.get(1))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{3, 0, -2, -1, 1, 2};

        System.out.println(solution.threeSum(arr));
    }
}
