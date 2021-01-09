package com.dealsky.leetcode.solution._024两两交换链表中的节点;

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/

import com.dealsky.leetcode.util.ListNode;

/**
 * @author dealsky
 * @date 2019-06-06 15:24
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;

        return second;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        solution.swapPairs(listNode1);
    }
}
