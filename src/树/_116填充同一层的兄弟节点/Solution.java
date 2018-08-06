package 树._116填充同一层的兄弟节点;

// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        connectImpl(root, null, false);
    }

    private void connectImpl(TreeLinkNode current, TreeLinkNode father, boolean leftFlag) {
        if (null == current) {
            return;
        }

        if (null != father) {
            if (leftFlag) {
                current.next = father.right;
            } else {
                current.next = null == father.next ? null : father.next.left;
            }
        }

        connectImpl(current.right, current, false);
        connectImpl(current.left, current, true);
    }
}
