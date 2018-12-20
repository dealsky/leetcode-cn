package com.dealsky.leetcode.solution._334递增的三元子序列;

// https://leetcode-cn.com/problems/increasing-triplet-subsequence/description/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int count = 0;
        int temp = 0;
        boolean change = false;
        int[] arr = new int[3];

        for (int num : nums) {
            if (count == 0) {
                arr[0] = num;
                count++;
            } else if (count == 1) {
                if (num < arr[0]) {
                    arr[0] = num;
                } else if (num > arr[0]) {
                    arr[1] = num;
                    count++;
                }
            } else {
                if (num > arr[1]) {
                    count++;
                    break;
                } else if (num < arr[1]) {
                    if (change) {
                        if (num < temp) {
                            temp = num;
                        } else if (num > temp) {
                            arr[0] = temp;
                            arr[1] = num;
                            change = false;
                        }
                    } else {
                        if (num > arr[0]) {
                            arr[1] = num;
                        } else if (num < arr[0]) {
                            temp = num;
                            change = true;
                        }
                    }
                }
            }
        }

        return count == 3;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{5, 1, 5, 5, 2, 5, 4};

        System.out.println(solution.increasingTriplet(arr));
    }
}
