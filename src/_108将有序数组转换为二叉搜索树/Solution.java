package _108将有序数组转换为二叉搜索树;

import TreeNode;

import java.util.Arrays;

// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[len / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len / 2 + 1, len));

        return root;
    }

    public TreeNode getTree(int[] nums, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getTree(nums, l, mid - 1);
            root.right = getTree(nums, mid + 1, r);

            return root;
        } else {
            return null;
        }
    }
}
