package com.dealsky.leetcode.solution._049字母异位词分组;

// https://leetcode-cn.com/problems/group-anagrams/description/

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (map.containsKey(sortedStr)) {
                List<String> list = map.get(sortedStr);
                list.add(str);
            } else {
                map.put(sortedStr, new ArrayList<>(Collections.singletonList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(solution.groupAnagrams(strings));
    }
}
