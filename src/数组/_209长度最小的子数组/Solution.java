package 数组._209长度最小的子数组;

// https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1 && nums[0] < s) {
            return 0;
        }

        int slow = 0, fast = 0;
        int len = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        while (slow < len) {
            if (fast < len) {
                sum += nums[fast];
            } else if (sum < s) {
                break;
            }

            if (sum >= s) {
                while (sum >= s) {
                    min = Math.min(min, fast - slow + 1);
                    sum -= nums[slow++];
                }
            }

            fast = Math.min(len, fast + 1);
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7};

        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, nums));
    }
}
