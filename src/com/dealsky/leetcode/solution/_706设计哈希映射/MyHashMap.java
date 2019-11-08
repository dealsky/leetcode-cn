package com.dealsky.leetcode.solution._706设计哈希映射;

// https://leetcode-cn.com/problems/design-hashmap/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dealsky
 * @date 2019/11/8 3:30 下午
 */
public class MyHashMap {

    private static final Integer SIZE = (int) (10000 * 0.75);

    private List<Entity>[] array;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        array = new ArrayList[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        Entity entity = new Entity(key, value);
        if (array[index] == null) {
            array[index] = new ArrayList<>(Collections.singleton(entity));
        } else {
            for (Entity item : array[index]) {
                if (item.key == key) {
                    item.value = value;
                    return;
                }
            }
            array[index].add(entity);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (!contains(key)) {
            return -1;
        }
        int index = hash(key);
        for (Entity item : array[index]) {
            if (item.key == key) {
                return item.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int index = hash(key);
        for (Entity item : array[index]) {
            if (item.key == key) {
                array[index].remove(item);
                return;
            }
        }
    }

    private boolean contains(int key) {
        int index = hash(key);
        if (array[index] == null) {
            return false;
        }

        List<Entity> list = array[index];
        for (Entity item : list) {
            if (item.key == key) {
                return true;
            }
        }

        return false;
    }

    private int hash(int key) {
        return key % SIZE;
    }

    private static class Entity {
        int key;
        int value;

        public Entity(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // 返回 1
        hashMap.get(3);            // 返回 -1 (未找到)
        hashMap.put(2, 1);         // 更新已有的值
        hashMap.get(2);            // 返回 1
        hashMap.remove(2);         // 删除键为2的数据
        hashMap.get(2);            // 返回 -1 (未找到)
    }
}
