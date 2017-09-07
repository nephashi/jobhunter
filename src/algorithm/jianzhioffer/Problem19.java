package algorithm.jianzhioffer;

public class Problem19 {
    public static void Mirror(BinaryTreeNode<Integer> treeRoot) {
        if(treeRoot == null) return;
        BinaryTreeNode<Integer> tmp = treeRoot.getLeftChild();
        treeRoot.setLeftChild(treeRoot.getRightChild());
        treeRoot.setRightChild(tmp);
        Mirror(treeRoot.getLeftChild());
        Mirror(treeRoot.getRightChild());
    }
}
