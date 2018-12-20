package com.dealsky.leetcode.solution._019删除链表的倒数第N个节点;

// https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return head.next;
        }

        ListNode preNode = head;
        while (temp.next != null) {
            preNode = preNode.next;
            temp = temp.next;
        }
        preNode.next = preNode.next.next;

        return head;
    }
}
