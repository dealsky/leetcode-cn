package _103二叉树的锯齿形层次遍历;

// https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);

        boolean flag = true;
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            TreeNode current = null;

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (flag) {
                     current = deque.removeFirst();
                     if (null != current.left) {
                         deque.addLast(current.left);
                     }
                     if (null != current.right) {
                         deque.addLast(current.right);
                     }
                } else {
                    current = deque.removeLast();
                    if (null != current.right) {
                        deque.addFirst(current.right);
                    }
                    if (null != current.left) {
                        deque.addFirst(current.left);
                    }
                }

                list.add(current.val);
            }

            flag = !flag;
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        System.out.println(solution.zigzagLevelOrder(treeNode3));
    }
}
