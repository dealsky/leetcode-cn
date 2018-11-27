package _061旋转链表;

// https://leetcode-cn.com/problems/rotate-list/description/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = lenList(head);
        if (len == 0) {
            return head;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        int pos = len - k;
        int count = 0;
        ListNode node = head;
        ListNode current = null;
        ListNode preCurrent = null;
        ListNode end = null;

        while(node != null) {
            if (count == pos - 1) {
                preCurrent = node;
            }
            if (count == pos) {
                current = node;
            }
            if (node.next == null) {
                end = node;
            }

            count++;
            node = node.next;
        }
        if (preCurrent != null) {
            preCurrent.next = null;
        }
        end.next = head;
        head = current;

        return head;
    }

    private int lenList(ListNode head) {
        if (head == null) {
            return 0;
        } else {
            int len = 1;
            while (head.next != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
//        util.ListNode listNode4 = new util.ListNode(4);
//        util.ListNode listNode5 = new util.ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
//        listNode4.next = listNode5;
//        listNode5.next = null;

        Solution solution = new Solution();
        ListNode listNode = solution.rotateRight(listNode1, 4);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
