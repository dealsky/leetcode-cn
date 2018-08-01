package 链表._328奇偶链表;

import 链表.ListNode;

// https://leetcode-cn.com/problems/odd-even-linked-list/description/

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode cur = head.next.next;
        ListNode pre = head.next;
        boolean flag = true;

        while (cur != null) {
            if (flag) {
                pre.next = cur.next;
                cur.next = slow.next;
                slow.next = cur;
                slow = cur;
                cur = pre;
            } else {
                pre = cur;
            }

            cur = cur.next;
            flag = !flag;
        }

        return head;
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
        listNode5.next = null;

        Solution solution = new Solution();
        ListNode listNode = solution.oddEvenList(listNode1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
