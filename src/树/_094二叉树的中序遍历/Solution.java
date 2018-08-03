package 树._094二叉树的中序遍历;

// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/

import 树.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            inorderTraversal(treeNode.left, list);
            list.add(treeNode.val);
            inorderTraversal(treeNode.right, list);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }

            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;

        Solution solution = new Solution();

        System.out.println(solution.inorderTraversal2(treeNode1));
    }
}
