package _060第k个排列;

// https://leetcode-cn.com/problems/permutation-sequence/

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int[] factors = new int[n];
        factors[0] = 1;
        for (int i = 1; i < n; i++) {
            factors[i] = factors[i - 1] * i;
        }

        k--;
        StringBuilder builder = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / factors[i];
            builder.append(nums.remove(index));
            k = k % factors[i];
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.getPermutation(9, 362880));
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }
}
