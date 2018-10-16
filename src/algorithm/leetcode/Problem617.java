package algorithm.leetcode;

public class Problem617 {


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else {
            TreeNode node = new TreeNode(0);
            if (t1 == null && t2 != null) {
                node.val = t2.val;
                node.left = mergeTrees(null, t2.left);
                node.right = mergeTrees(null, t2.right);
            } else if (t1 != null && t2 == null) {
                node.val = t1.val;
                node.left = mergeTrees(t1.left, null);
                node.right = mergeTrees(t1.right, null);
            } else {
                node.val = t1.val + t2.val;
                node.left = mergeTrees(t1.left, t2.left);
                node.right = mergeTrees(t1.right, t2.right);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode root = mergeTrees(null, node);
        System.out.println();
    }

}
