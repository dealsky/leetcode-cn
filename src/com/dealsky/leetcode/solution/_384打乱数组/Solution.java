package com.dealsky.leetcode.solution._384打乱数组;

// https://leetcode-cn.com/problems/shuffle-an-array/description/

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int[] arr;
    private final Random random = new Random();


    public Solution(int[] nums) {
        arr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOfRange(arr,0, arr.length);

        for (int i = 1; i < result.length; i++) {
            int j = randomInt(0, i);

            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }

        return result;
    }

    public int randomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Solution solution = new Solution(arr);

        for (int i = 0; i < 10 ; i++) {
            int[] current = solution.shuffle();

            for (int num : current) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
