package _206反转链表;

// https://leetcode-cn.com/problems/reverse-linked-list/description/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        // return reverse(null, head);
        return reverse(head);
    }

    // 递归
    private ListNode reverse(ListNode pre, ListNode cur) {
        ListNode temp = cur.next;

        cur.next = pre;
        if (temp == null) {
            return cur;
        }

        return reverse(cur, temp);
    }

    // 非递归
    private ListNode reverse(ListNode head) {
        ListNode temp;
        ListNode pre = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }

    public static void main(String[] args) {

    }
}
