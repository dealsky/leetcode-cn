package _412FizzBuzz;

// https://leetcode-cn.com/problems/fizz-buzz/description/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder builder = new StringBuilder();

            if (i % 15 == 0) {
                builder.append("FizzBuzz");
            } else if (i % 3 == 0) {
                builder.append("Fizz");
            } else if (i % 5 == 0) {
                builder.append("Buzz");
            } else {
                builder.append(i);
            }

            list.add(builder.toString());
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (String str : solution.fizzBuzz(150000)) {
            System.out.println(str);
        }
    }
}
