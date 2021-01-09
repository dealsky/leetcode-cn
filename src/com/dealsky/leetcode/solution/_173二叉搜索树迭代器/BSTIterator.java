package com.dealsky.leetcode.solution._173二叉搜索树迭代器;

// https://leetcode-cn.com/problems/binary-search-tree-iterator/

import com.dealsky.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    private Integer index;

    private List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        index = 0;
        sequenceTraversal(root);
    }

    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }

    /**
     * 中序遍历
     */
    private void sequenceTraversal(TreeNode node) {
        if (node != null) {
            sequenceTraversal(node.left);
            list.add(node.val);
            sequenceTraversal(node.right);
        }
    }
}
