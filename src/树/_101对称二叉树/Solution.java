package 树._101对称二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return traverse(root.left, root.right);
    }

    private boolean traverse(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return traverse(root1.left, root2.right) && traverse(root1.right, root2.left);
    }
}
