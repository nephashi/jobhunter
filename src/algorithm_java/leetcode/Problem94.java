package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94 {

    public static void inOrder(TreeNode root, List<Integer> rst) {
        if (root == null)
            return;
        inOrder(root.left, rst);
        rst.add(root.val);
        inOrder(root.right, rst);
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        inOrder(root, rst);
        return rst;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> rst = new ArrayList<>();
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode cur = stack.pop();
                rst.add(cur.val);
                p = cur.right;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;

        List<Integer> ans = inorderTraversal(a);
        System.out.println();
    }
}
