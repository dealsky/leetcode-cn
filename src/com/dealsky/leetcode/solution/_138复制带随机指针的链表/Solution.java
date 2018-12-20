package com.dealsky.leetcode.solution._138复制带随机指针的链表;

// https://leetcode-cn.com/problems/copy-list-with-random-pointer/description/

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode result = new RandomListNode(0);
        RandomListNode current = result;
        RandomListNode oldCurrent = head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (oldCurrent != null) {
            current.next = new RandomListNode(oldCurrent.label);
            current = current.next;
            map.put(oldCurrent, current);
            oldCurrent = oldCurrent.next;
        }

        current = result.next;
        oldCurrent = head;

        while (oldCurrent != null) {
            current.random = map.get(oldCurrent.random);
            current = current.next;
            oldCurrent = oldCurrent.next;
        }

        return result.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode current = head;
        while (current != null) {
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            current.next = temp;
            current = temp.next;
        }

        current = head;
        while (current != null) {
            RandomListNode temp = current.next;
            if (current.random != null) {
                temp.random = current.random.next;
            }
            current = temp.next;
        }

        RandomListNode result = head.next;
        current = head;
        while (current != null) {
            RandomListNode temp = current.next;
            current.next = temp.next;

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            current = current.next;
        }

        return result;
    }
}
