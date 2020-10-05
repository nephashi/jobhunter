package algorithm.leetcode;

public class Problem572 {

    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.val != b.val)
            return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null)
            return true;
        if (s == null)
            return false;
        if (isSameTree(s, t))
            return true;
        boolean l = isSubtree(s.left, t);
        boolean r = isSubtree(s.right, t);
        return l || r;

    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(1);
        TreeNode a6 = new TreeNode(1);
        TreeNode a7 = new TreeNode(2);
        a1.right = a2;
        a2.right = a3;
        a3.right = a4;
        a4.right = a5;
        a5.right = a6;
        a6.left = a7;

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(1);
        TreeNode b3 = new TreeNode(1);
        TreeNode b4 = new TreeNode(2);
        b1.right = b2;
        b2.right = b3;
        b3.left = b4;

        System.out.println(isSubtree(a1, b1));
    }

}
