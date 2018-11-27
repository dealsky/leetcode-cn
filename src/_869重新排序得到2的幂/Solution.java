package _869重新排序得到2的幂;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        List<String> list = new ArrayList<>();

        int num = 1;
        for (int i = 0; i < 30; i++) {
            char[] charArr = String.valueOf(num).toCharArray();
            Arrays.sort(charArr);
            list.add(new String(charArr));

            num = num << 1;
        }

        char[] charArr = String.valueOf(N).toCharArray();
        Arrays.sort(charArr);

        String sortedStr = new String(charArr);
        for (String str : list) {
            if (sortedStr.equals(str)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reorderedPowerOf2(0));
    }
}
