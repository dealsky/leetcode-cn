package 树._98验证二叉搜索树;

// https://leetcode-cn.com/problems/validate-binary-search-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (pan(root.left, root.val, "left")) {
                if (!isValidBST(root.left)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (root.right != null) {
            if (pan(root.right, root.val, "right")) {
                if (!isValidBST(root.right)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean pan(TreeNode root, int val, String method) {
        if (method.equals("left") && root.val >= val || method.equals("right") && root.val <= val) {
            return false;
        }

        if (root.left != null) {
            if (!pan(root.left, val, method)) {
                return false;
            }
        }

        if (root.right != null) {
            if (!pan(root.right, val, method)) {
                return false;
            }
        }

        return true;
    }
}
