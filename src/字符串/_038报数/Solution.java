package 字符串._038报数;

// https://leetcode-cn.com/problems/count-and-say/description/

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        if (n == 2) {
            return "11";
        }

        char current;
        int count;

        String str = "11";
        for (int i = 2; i < n; i++) {
            int len = str.length();

            StringBuilder builder = new StringBuilder();
            current = str.charAt(0);
            count = 1;
            for (int j = 0; j < len - 1; j++) {
                if (str.charAt(j) == str.charAt(j + 1)) {
                    count++;
                } else {
                    builder.append(count).append(current);
                    current = str.charAt(j + 1);
                    count = 1;
                }
            }

            if (str.charAt(len - 1) == str.charAt(len - 2)) {
                builder.append(count).append(current);
            } else {
                builder.append(1).append(str.charAt(len - 1));
            }

            str = builder.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1 ; i <= 10; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
