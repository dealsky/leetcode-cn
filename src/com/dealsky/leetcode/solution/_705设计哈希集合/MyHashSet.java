package com.dealsky.leetcode.solution._705设计哈希集合;

// https://leetcode-cn.com/problems/design-hashmap/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dealsky
 * @date 2019/11/8 2:59 下午
 */
public class MyHashSet {

    private static final Integer SIZE = (int) (10000 * 0.75);

    private List<Integer>[] array;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        array = new ArrayList[SIZE];
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int index = hash(key);
        if (array[index] == null) {
            array[index] = new ArrayList<>(Collections.singletonList(key));
        } else {
            array[index].add(key);
        }
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int index = hash(key);
        array[index].remove((Integer) key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hash(key);
        if (array[index] == null) {
            return false;
        }

        List<Integer> list = array[index];
        for (Integer item : list) {
            if (item.equals(key)) {
                return true;
            }
        }

        return false;
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // 返回 true
        hashSet.contains(3);    // 返回 false (未找到)
        hashSet.add(2);
        hashSet.contains(2);    // 返回 true
        hashSet.remove(2);
        hashSet.contains(2);    // 返回  false (已经被删除)
    }
}
