package _007反转整数;

// https://leetcode-cn.com/problems/reverse-integer/description/

public class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);

        long max = 2147483647;
        Boolean flag = false;

        if (str.charAt(0) == '-') {
            flag = true;
            str = str.substring(1);
        }
        str = reverseString(str);

        if (!flag) {
            if (Long.valueOf(str) <= max) {
                return Integer.valueOf(str);
            }
        } else {
            if (Long.valueOf(str) <= max + 1) {
                return -Integer.valueOf(str);
            }
        }

        return 0;
    }

    private String reverseString(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }


    public int reverse2(int x) {
        int flag = 1;

        if (x < 0) {
            flag = -1;
            x = -x;
        }

        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result * flag;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverse2(123));

        // System.out.println(solution.reverse(0));
    }
}
