package com.dealsky.leetcode.solution._002两数相加;

import com.dealsky.leetcode.util.ListNode;

// https://leetcode-cn.com/problems/add-two-numbers/description/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;

        int temp = 0;
        while (null != l1 || null != l2) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + temp;

            if (sum >= 10) {
              sum -= 10;
              temp = 1;
            } else {
                temp = 0;
            }

            listNode.next = new ListNode(sum);
            listNode = listNode.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (temp == 1) {
            listNode.next = new ListNode(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        ListNode listNode3 = new ListNode(8);
        listNode3.next = null;
        listNode.next = listNode3;

        ListNode listNode1 = new ListNode(1);
        listNode1.next = null;

        Solution solution = new Solution();

        ListNode result = solution.addTwoNumbers(listNode, listNode1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
