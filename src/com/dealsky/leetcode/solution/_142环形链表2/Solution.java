package com.dealsky.leetcode.solution._142环形链表2;

// https://leetcode-cn.com/problems/linked-list-cycle-ii/description/

import com.dealsky.leetcode.util.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
