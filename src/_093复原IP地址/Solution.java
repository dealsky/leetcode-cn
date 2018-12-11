package _093复原IP地址;

// https://leetcode-cn.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 16 || s.length() < 4) {
            return result;
        }
        restoreIpAddressesProxy(s, 0, 1, new ArrayList<>(), result);
        return result;
    }

    private void restoreIpAddressesProxy(String s, int start, int level, List<String> temp, List<String> result) {
        for (int i = start + 1; i <= start + 3 && i <= s.length(); i++) {
            String current = s.substring(start, i);
            if (legalSubString(current)) {
                temp.add(current);
            } else {
                continue;
            }

            if (level == 4) {
                if (i == s.length()) {
                    result.add(arr2Str(temp));
                }
            } else {
                restoreIpAddressesProxy(s, i, level + 1, temp, result);
            }

            temp.remove(temp.size() - 1);
        }
    }

    private boolean legalSubString(String str) {
        if (str.length() > 3 || str.length() < 1) {
            return false;
        }

        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }

        int num = Integer.valueOf(str);
        return num >= 0 && num <= 255;
    }

    private String arr2Str(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                builder.append(".");
            }
            builder.append(list.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
