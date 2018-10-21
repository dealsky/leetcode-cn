package 字符串._151翻转字符串里的单词;

/**
 * @author dealsky
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].trim().isEmpty()) {
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(strings[i]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("  the   sky   is blue  "));
    }
}
