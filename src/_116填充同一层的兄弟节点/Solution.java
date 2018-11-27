package _116填充同一层的兄弟节点;

// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/

import java.util.ArrayDeque;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }

        if (null != root.left) {
            root.left.next = root.right;

            if (null != root.next) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    public void connect2(TreeLinkNode root) {
        if (null == root) {
            return;
        }

        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = null;

            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = queue.poll();

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                if (pre != null) {
                    pre.next = cur;
                }

                pre = cur;
            }
        }
    }
}
