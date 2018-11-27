package _237删除链表中的节点;

// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
