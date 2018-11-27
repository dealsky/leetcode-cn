package _203移除链表元素;

import util.ListNode;

/**
 * @author dealsky
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }

        return head;
    }
}
