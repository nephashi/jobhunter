package algorithm;

import algorithm.leetcode.TreeNode;

public class RemoveBSTNode {

    public static TreeNode removeBSTNode(TreeNode root, int value) {
        if (root == null)
            return root;
        if (value < root.val) {
            root.left = removeBSTNode(root.left, value);
        } else if (value > root.val) {
            root.right = removeBSTNode(root.right, value);
        } else {
            if (root.left == null || root.right == null) {
                root = root.left != null ? root.left : root.right;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = removeBSTNode(root.right, cur.val);
            }
        }
        return root;
    }

}
