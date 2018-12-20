package com.dealsky.leetcode.solution._707设计链表;

/**
 * @author dealsky
 */
public class MyLinkedList2 {

    private int val;

    private MyLinkedList2 next;

    private MyLinkedList2 prev;

    private int length;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
    }

    public MyLinkedList2(int val) {
        this.val = val;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (!isValid(index)) {
            return -1;
        }

        int count = 0;
        MyLinkedList2 current = this;
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
            MyLinkedList2 oldHead = new MyLinkedList2(this.val);
            oldHead.next = this.next;
            oldHead.prev = this;
            if (oldHead.next != null){
                oldHead.next.prev = oldHead;
            }
            this.val = val;
            this.next = oldHead;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (length == 0) {
            this.val = val;
        } else {
            MyLinkedList2 current = this;
            while (current.next != null) {
                current = current.next;
            }
            MyLinkedList2 tailNode = new MyLinkedList2(val);
            tailNode.prev = current;
            current.next = tailNode;
        }
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        if (index == length) {
            addAtTail(val);
            return;
        }

        int count = 0;
        MyLinkedList2 current = this;
        while (count < index) {
            current = current.next;
            count++;
        }
        MyLinkedList2 newNode = new MyLinkedList2(val);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (!isValid(index)) {
            return;
        }
        if (index == 0) {
            if (this.next != null) {
                this.val = this.next.val;
                this.next = this.next.next;
                this.next.prev = this;
            }
        } else {
            int count = 0;
            MyLinkedList2 current = this;
            while (count < index) {
                current = current.next;
                count++;
            }
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        length--;
    }

    private boolean isValid(int index) {
        return index >= 0 && index < length;
    }

    public static void main(String[] args) {
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(7);
        myLinkedList2.addAtHead(2);
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtIndex(3, 0);
        myLinkedList2.deleteAtIndex(2);
        myLinkedList2.addAtHead(6);
        myLinkedList2.addAtTail(4);
        System.out.println(myLinkedList2.get(4));
        myLinkedList2.addAtHead(4);
        myLinkedList2.addAtIndex(5, 0);
        myLinkedList2.addAtHead(6);
    }
}

// ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
// [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]