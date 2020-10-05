package algorithm.jianzhioffer;

import java.util.Stack;

public class Problem25 {
    public static void printSumPath(Stack<Integer> stack, BinaryTreeNode<Integer> root, int sum, int target) {
        if (root ==  null)
            return;
        stack.push(root.getData());
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            if(sum + root.getData() == target) {
                for (Integer e : stack) {
                    System.out.println(e);
                }
            }
            stack.pop();
            return;
        }
        sum += root.getData();
        if(sum > target) {
            stack.pop();
            return;
        }
        if (root.getLeftChild() != null) {
            printSumPath(stack, root.getLeftChild(), sum, target);
        }
        if (root.getRightChild() != null) {
            printSumPath(stack, root.getRightChild(), sum, target);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node4, node7);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12, null, null);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10, node5, node12);
        printSumPath(new Stack<Integer>(), root, 0, 22);
    }
}
