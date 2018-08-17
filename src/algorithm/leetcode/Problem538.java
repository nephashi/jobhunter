package algorithm.leetcode;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }

    public static int traverse(TreeNode root, int greaterValue) {
        if (root == null)
            return 0;
        int right = traverse(root.right, greaterValue);
        int left = traverse(root.left, greaterValue + right + root.val);
        int val = right + left + root.val;
        root.val += greaterValue + right;
        return val;
    }
}
