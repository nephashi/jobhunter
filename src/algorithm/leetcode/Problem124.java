package algorithm.leetcode;

public class Problem124 {

    public static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(maxPathSum(root.left), maxPathSum(root.right)) + root.val;
    }

}
