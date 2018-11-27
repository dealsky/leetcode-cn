package _104二叉树的最大深度;

import TreeNode;

// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
