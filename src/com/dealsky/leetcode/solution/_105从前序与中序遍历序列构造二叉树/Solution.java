package com.dealsky.leetcode.solution._105从前序与中序遍历序列构造二叉树;

// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import com.dealsky.leetcode.util.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return buildTreeImpl(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeImpl(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }

        int leftLength = rootIndex - inStart;

        if (leftLength > 0) {
            root.left = buildTreeImpl(preorder, preStart + 1,  preStart + leftLength, inorder, inStart, rootIndex - 1);
        }

        if (inEnd - rootIndex > 0) {
            root.right = buildTreeImpl(preorder, preStart + leftLength + 1, preEnd, inorder, rootIndex + 1, inEnd);
        }

        return root;
    }
}
