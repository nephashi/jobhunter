package algorithm.leetcode;

public class Problem543 {

    public static int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int a = treeDepth(root.left);
        int b = treeDepth(root.right);
        int c = diameterOfBinaryTree(root.left);
        int d = diameterOfBinaryTree(root.right);
        int res = Math.max(a + b, Math.max(c, d));
        return res;
    }

}
