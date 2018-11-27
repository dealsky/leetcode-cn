package _297二叉树的序列化与反序列化;

// https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        int right = 0;
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.removeFirst();

            if (builder.length() > 1) {
                builder.append(",");
            }

            if (treeNode == null) {
                builder.append("null");
                continue;
            } else {
                builder.append(treeNode.val);
                right = builder.length();
            }

            deque.addLast(treeNode.left);
            deque.addLast(treeNode.right);
        }

        return builder.substring(0, right) + "]";
    }

    public TreeNode deserialize(String data) {
        data = data.replace(" ", "");
        data = data.substring(1, data.length() - 1);
        String[] arr = data.split(",");

        if (arr[0].equals("null") || arr[0].equals("")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        int index = 1;
        while (!deque.isEmpty() && index < arr.length) {
            TreeNode current = deque.removeFirst();
            TreeNode treeNode;

            String str = arr[index];
            if (!str.equals("null")) {
                treeNode = new TreeNode(Integer.valueOf(str));
                current.left = treeNode;
                deque.addLast(treeNode);
            }

            if (index + 1 >= arr.length) {
                break;
            } else {
                str = arr[++index];

                if (!str.equals("null")) {
                    treeNode = new TreeNode(Integer.valueOf(str));
                    current.right = treeNode;
                    deque.addLast(treeNode);
                }
            }

            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode treeNode = codec.deserialize("[null]");
        System.out.println(codec.serialize(treeNode));
    }
}
