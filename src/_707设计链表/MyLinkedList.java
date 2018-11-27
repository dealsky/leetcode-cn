package _707设计链表;

// https://leetcode-cn.com/problems/design-linked-list/description/

public class MyLinkedList {

    private int val;

    private MyLinkedList next;

    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        length = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (!valid(index)) {
            return -1;
        }
        MyLinkedList current = this;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (length == 0) {
            this.val = val;
        } else {
            MyLinkedList head = new MyLinkedList();
            head.val = this.val;
            head.next = this.next;
            this.val = val;
            this.next = head;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (length == 0) {
            addAtHead(val);
            return;
        }
        MyLinkedList current = this;
        while (current.next != null) {
            current = current.next;
        }
        MyLinkedList last = new MyLinkedList();
        last.val = val;
        current.next = last;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == length) {
            addAtTail(val);
            return;
        }

        if (!valid(index)) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else {
            MyLinkedList pre = this;
            int count = 0;
            while (count < index - 1) {
                pre = pre.next;
                count++;
            }
            MyLinkedList node = new MyLinkedList();
            node.val = val;
            node.next = pre.next;
            pre.next = node;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (!valid(index)) {
            return;
        }

        if (index == 0) {
            this.val = this.next.val;
            this.next = this.next.next;
        } else {
            MyLinkedList pre = this;
            int current = 0;
            while (current < index - 1) {
                pre = pre.next;
                current++;
            }
            pre.next = pre.next.next;
        }
        length--;
    }

    private boolean valid(int index) {
        return index >= 0 && index < length;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.get(0);
        linkedList.addAtIndex(1, 2);
        linkedList.get(0);
        linkedList.get(1);
        linkedList.addAtIndex(0,1);
        linkedList.get(0);
        linkedList.get(1);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

