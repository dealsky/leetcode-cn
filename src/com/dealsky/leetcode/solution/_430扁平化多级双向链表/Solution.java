package com.dealsky.leetcode.solution._430扁平化多级双向链表;

// https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/description/

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        handleChildren(null, head);
        return head;
    }

    private Node handleChildren(Node head, Node current) {
        current.prev = head;
        Node pre = current;
        while (current != null) {
            pre = current;
            if (current.child != null) {
                Node node = handleChildren(current, current.child);
                node.next = current.next;
                if (current.next != null) {
                    current.next.prev = node;
                }
                current.next = current.child;
                current.child = null;
            } else {
                current = current.next;
            }
        }

        return pre;
    }
}
