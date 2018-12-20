package com.dealsky.leetcode.solution._230二叉搜索树中第K小的元素;

// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/

import com.dealsky.leetcode.util.TreeNode;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestProxy(root, new int[]{k});
    }

    private int kthSmallestProxy(TreeNode root, int[] arr) {
        if (null == root) {
            return -1;
        }

        int result = kthSmallestProxy(root.left, arr);
        if (arr[0] == 0) {
            return result;
        }
        if (arr[0]-- == 1) {
            return root.val;
        }
        return kthSmallestProxy(root.right, arr);
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);

        treeNode3.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode1.right = treeNode2;

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(treeNode3, 1));
    }
}
