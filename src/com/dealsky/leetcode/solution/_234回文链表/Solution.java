package com.dealsky.leetcode.solution._234回文链表;

// https://leetcode-cn.com/problems/palindrome-linked-list/description/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        mid = reverse(mid);

        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }

        return true;
    }

    private ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next.next;
            head = head.next;
        }

        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode temp;

        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
}
