package algorithm.leetcode;

public class Problem100 {

    public static boolean inner(TreeNode a, TreeNode b) {
        if ((a == null) ^ (b == null))
            return false;
        else if (a == null && b == null)
            return true;
        else if (a.val == b.val)
            return inner(a.left, b.left) && inner(a.right, b.right);
        else
            return false;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return inner(p, q);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(2);
        a.left = b;
        c.right = d;
        System.out.println(isSameTree(a,c));
    }
}
