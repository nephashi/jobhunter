package algorithm.jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Problem23 {

    void printFromTopToBottom(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> cur = queue.poll();
            System.out.println(cur.getData());
            if (cur.getLeftChild() != null)
                queue.offer(cur.getLeftChild());
            if (cur.getRightChild() != null)
                queue.offer(cur.getRightChild());
        }
    }
}
