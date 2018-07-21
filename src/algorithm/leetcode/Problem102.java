package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> current = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;
        else
            current.offer(root);

        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> next = new LinkedList<>();
            while (!current.isEmpty()) {
                TreeNode tn = current.poll();
                level.add(tn.val);
                if (tn.left != null)
                    next.offer(tn.left);
                if (tn.right != null)
                    next.offer(tn.right);
            }
            res.add(level);
            current = next;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        List<List<Integer>> res = levelOrder(a);
        System.out.println();
    }
}
