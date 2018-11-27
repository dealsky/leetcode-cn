package _622设计循环队列;

/**
 * @author dealsky
 */
public class MyCircularQueue {

    private int[] value;

    private int head, tail;

    private int size;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        head = 0;
        tail = 0;
        size = k + 1;
        value = new int[k + 1];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        tail = (tail + 1) % size;
        this.value[tail] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = (head + 1) % size;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : value[(head + 1) % size];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : value[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3

        System.out.println(circularQueue.enQueue(1));   // 返回true

        System.out.println(circularQueue.enQueue(2));  // 返回true

        System.out.println(circularQueue.enQueue(3));  // 返回true

        System.out.println(circularQueue.enQueue(4));  // 返回false,队列已满

        System.out.println(circularQueue.Rear());  // 返回3

        System.out.println(circularQueue.isFull());  // 返回true

        System.out.println(circularQueue.deQueue());  // 返回true

        System.out.println(circularQueue.enQueue(4));  // 返回true

        System.out.println(circularQueue.Rear());  // 返回4
    }
}
