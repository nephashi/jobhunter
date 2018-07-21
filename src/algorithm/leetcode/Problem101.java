package algorithm.leetcode;

public class Problem101 {

    public static boolean isSymmetric(TreeNode a, TreeNode b) {
        return (a == b) || (a != null && b != null && a.val == b.val &&
                isSymmetric(a.left, b.right) && isSymmetric(b.left, a.right));
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        isSymmetric(a);
    }
}
