package algorithm.leetcode;

public class Problem337 {

    public int[] inner(TreeNode n) {
        int[] v = new int[2];
        if (n != null) {
            int[] left = inner(n.left);
            int[] right = inner(n.right);
            // 不偷当前节点
            v[0] = left[1] + right[1];
            // 不限制
            v[1] = Math.max(left[0] + right[0] + n.val, v[0]);
        }
        return v;
    }

    public int rob(TreeNode root) {
        return inner(root)[1];
    }
}
