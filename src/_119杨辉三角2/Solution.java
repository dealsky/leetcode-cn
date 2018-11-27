package _119杨辉三角2;

// https://leetcode-cn.com/problems/pascals-triangle-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    private static List<List<Integer>> result;

    static {
        result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        result.add(Arrays.asList(1, 1));

        for (int i = 2; i <= 33; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return result.get(rowIndex);
    }

    public static void main(String[] args) {
    }
}
