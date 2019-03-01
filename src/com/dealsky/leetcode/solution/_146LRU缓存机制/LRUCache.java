package com.dealsky.leetcode.solution._146LRU缓存机制;

// https://leetcode-cn.com/problems/lru-cache/

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private int capacity;

    private Map<Integer, Integer> data;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new LinkedHashMap<>(capacity * 2, 0.75f, true);
    }

    public int get(int key) {
        return data.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        data.put(key, value);
        if (data.size() > capacity) {
            for (int k : data.keySet()) {
                data.remove(k);
                break;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        LRUCache cache = new LRUCache(10);
        System.out.println(cache.get(10));
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        System.out.println(cache.get(13));
        cache.put(2, 19);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(5, 25);
        System.out.println(cache.get(8));
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        System.out.println(cache.get(11));
        cache.put(9, 12);
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        System.out.println(cache.get(8));
        System.out.println(cache.get(9));
        cache.put(4, 30);
        cache.put(9, 3);
        System.out.println(cache.get(9));
        System.out.println(cache.get(10));
        System.out.println(cache.get(10));
        cache.put(6, 14);
        cache.put(3, 1);
        System.out.println(cache.get(3));
        cache.put(10, 11);
        System.out.println(cache.get(8));
        cache.put(2, 14);
        System.out.println(cache.get(1));
        System.out.println(cache.get(5));
        System.out.println(cache.get(4));
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        System.out.println(cache.get(13));
        cache.put(7, 23);
        System.out.println(cache.get(8));
        System.out.println(cache.get(12));
        cache.put(3, 27);
        cache.put(2, 12);
        System.out.println(cache.get(5));
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        System.out.println(cache.get(6));
        cache.put(9, 29);
        cache.put(8, 21);
        System.out.println(cache.get(5));
        cache.put(6, 30);
        cache.put(1, 12);
        System.out.println(cache.get(10));
        cache.put(4, 15);
        cache.put(7, 22);
        cache.put(11, 26);
        cache.put(8, 17);
        cache.put(9, 29);
        System.out.println(cache.get(5));
        cache.put(3, 4);
        cache.put(11, 30);
        System.out.println(cache.get(12));
        cache.put(4, 29);
        System.out.println(cache.get(3));
        System.out.println(cache.get(9));
        System.out.println(cache.get(6));
        cache.put(3, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.put(3, 29);
        cache.put(10, 28);
        cache.put(1, 20);
        cache.put(11, 13);
        System.out.println(cache.get(3));
        cache.put(3, 12);
        cache.put(3, 8);
        cache.put(10, 9);
        cache.put(3, 26);
        System.out.println(cache.get(8));
        System.out.println(cache.get(7));
        System.out.println(cache.get(5));
        cache.put(13, 17);
        cache.put(2, 27);
        cache.put(11, 15);
        System.out.println(cache.get(12));
        cache.put(9, 19);
        cache.put(2, 15);
        cache.put(3, 16);
        System.out.println(cache.get(1));
        cache.put(12, 17);
        cache.put(9, 1);
        cache.put(6, 19);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        System.out.println(cache.get(5));
        cache.put(8, 1);
        cache.put(11, 7);
        cache.put(5, 2);
        cache.put(9, 28);
        System.out.println(cache.get(1));
        cache.put(2, 2);
        cache.put(7, 4);
        cache.put(4, 22);
        cache.put(7, 24);
        cache.put(9, 26);
        cache.put(13, 28);
        cache.put(11, 26);

        System.out.println("time: " + (System.nanoTime() - start));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
