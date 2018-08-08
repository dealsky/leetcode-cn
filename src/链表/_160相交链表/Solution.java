package 链表._160相交链表;

// https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/

import 链表.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    int getLength(ListNode listNode) {
        int count = 0;
        while (listNode != null) {
            count++;
            listNode = listNode.next;
        }

        return count;
    }
}
