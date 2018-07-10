package 其他._118杨辉三角;

// https://leetcode-cn.com/problems/pascals-triangle/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();

            if (i == 1) {
                list.add(1);
            } else {
                list.add(1);
                for (int j = 2; j <= i - 1; j++) {
                    list.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j - 2));
                }
                list.add(1);
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> result = solution.generate(5);

        for (List list : result) {
            System.out.println(list);
        }
    }
}
