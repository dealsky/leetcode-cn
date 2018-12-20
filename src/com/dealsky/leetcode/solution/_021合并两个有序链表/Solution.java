package com.dealsky.leetcode.solution._021合并两个有序链表;

// https://leetcode-cn.com/problems/merge-two-sorted-lists/description/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            ListNode next = new ListNode(0);

            if (l1.val < l2.val) {
                next.val = l1.val;
                temp.next = next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                next.val = l2.val;
                temp.next = l2;
                l2 = l2.next;
            } else {
                next.val = l1.val;
                next.next = new ListNode(l2.val);
                temp.next = next;
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        ListNode listNode = solution.mergeTwoLists(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
