package _167两数之和2输入有序数组;

// https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/785/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }
}
