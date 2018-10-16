package algorithm.nowcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> nexts = new ArrayList<>();

    MultiTreeNode(int val) {
        this.val = val;
    }
}

public class XiaoMiGit {

    public static MultiTreeNode getLowestParents(MultiTreeNode root, MultiTreeNode a, MultiTreeNode b) {
        if (root == null || root == a || root == b)
            return root;
        List<MultiTreeNode> nextLowests = new ArrayList<>();
        List<Integer> validIdxs = new ArrayList<>();
        for (int i = 0; i < root.nexts.size(); i++) {
            MultiTreeNode n = getLowestParents(root.nexts.get(i), a, b);
            if (n != null)
                nextLowests.add(n);
        }
        if (nextLowests.size() >= 2)
            return root;
        else if (nextLowests.size() == 1)
            return nextLowests.get(0);
        else
            return null;
    }

    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        if (matrix.length == 1) {
            return 0;
        }

        Queue<MultiTreeNode> queue = new LinkedList<>();
        MultiTreeNode root = new MultiTreeNode(0);
        queue.offer(root);
        boolean[] used = new boolean[matrix.length];
        used[0] = true;

        MultiTreeNode a = indexA == 0 ? root : null;
        MultiTreeNode b = indexB == 0 ? root : null;

        while (!queue.isEmpty()) {
            MultiTreeNode n = queue.poll();
            int val = n.val;
            String friends = matrix[val];
            for (int i = 0; i < friends.length(); i++) {
                if (friends.charAt(i) == '1' && used[i] == false) {
                    MultiTreeNode newNode = new MultiTreeNode(i);
                    if (i == indexA)
                        a = newNode;
                    if (i == indexB)
                        b = newNode;
                    n.nexts.add(newNode);
                    queue.offer(newNode);
                    used[i] = true;
                }
            }
        }

        MultiTreeNode p = getLowestParents(root, a, b);

        return p.val;
    }

    public static void main(String[] args) {
        getSplitNode(new String[]{
                "01", "10"
        }, 0, 0);
    }

}
