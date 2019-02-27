package com.dealsky.leetcode.solution._023合并K个排序链表;

import com.dealsky.leetcode.util.ListNode;

import java.util.Arrays;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            return lists[0];
        } else {
            return merge(mergeKLists(Arrays.copyOf(lists, length / 2)), mergeKLists(Arrays.copyOfRange(lists, length / 2, length)));
        }
    }

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode result = new ListNode(0);
        ListNode listNode = result;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                listNode.next = new ListNode(listNode1.val);
                listNode1 = listNode1.next;
            } else {
                listNode.next = new ListNode(listNode2.val);
                listNode2 = listNode2.next;
            }
            listNode = listNode.next;
        }

        if (listNode1 != null) {
            listNode.next = listNode1;
        }

        if (listNode2 != null) {
            listNode.next = listNode2;
        }

        return result.next;
    }

    public static void main(String[] args) {

    }
}
