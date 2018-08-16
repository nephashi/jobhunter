package algorithm.leetcode;

public class Problem226 {

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
        }
        return root;
    }
}
