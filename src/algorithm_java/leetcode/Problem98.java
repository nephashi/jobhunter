package algorithm.leetcode;

// 终于AC了，这题有毒
public class Problem98 {

    public static boolean inner(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= high)
            return false;
        return inner(root.left, low, root.val) &&
                inner(root.right, root.val, high);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        else
            return inner(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(8);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(6);
        TreeNode i = new TreeNode(4);
        TreeNode j = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = j;
        System.out.println(isValidBST(a));
    }
}
