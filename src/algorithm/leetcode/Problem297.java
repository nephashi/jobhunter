package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem297 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> lst = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                lst.add(String.valueOf(cur.val));
            } else {
                lst.add("null");
            }
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lst.size(); i++) {
            sb.append(lst.get(i));
            if (i != lst.size() - 1)
                sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        String[] ss = data.split(",");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("null")) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(Integer.valueOf(ss[i])));
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = nodes.get(0);
        TreeNode cur = null;
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            TreeNode left = nodes.get(i++);
            TreeNode right = nodes.get(i++);
            cur.left = left;
            cur.right = right;
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        TreeNode r = deserialize("1,2,3,null,null,4,5,null,null,null,null");
        System.out.println();
    }
}
