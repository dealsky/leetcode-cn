package com.dealsky.leetcode.solution._432全O1的数据结构;

// https://leetcode-cn.com/problems/all-oone-data-structure/

import java.util.HashMap;
import java.util.Map;

class AllOne {

    private Map<String, Integer> data;

    /** Initialize your data structure here. */
    public AllOne() {
        data = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = data.getOrDefault(key, 0);
        data.put(key, val + 1);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (data.containsKey(key)) {
            int val = data.get(key);
            if (val == 1) {
                data.remove(key);
            } else {
                data.put(key, val - 1);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        int max = Integer.MIN_VALUE;
        String result = "";
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }

        return result;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        int min = Integer.MAX_VALUE;
        String result = "";
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() < min) {
                result = entry.getKey();
                min = entry.getValue();
            }
        }

        return result;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
