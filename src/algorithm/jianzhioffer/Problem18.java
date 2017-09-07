package algorithm.jianzhioffer;

public class Problem18 {
    public static boolean hasSubTree(BinaryTreeNode<Integer> treeRoot, BinaryTreeNode<Integer> subRoot) {
        boolean result = false;
        if(treeRoot != null && subRoot != null) {
            if(treeRoot.getData() == subRoot.getData()) {
                result = isSubTree(treeRoot, subRoot);
            }
            if(!result) {
                hasSubTree(treeRoot.getLeftChild(), subRoot);
            }
            if(!result) {
                hasSubTree(treeRoot.getRightChild(), subRoot);
            }
        }
        return result;
    }

    public static boolean isSubTree(BinaryTreeNode<Integer> treeRoot, BinaryTreeNode<Integer> subRoot) {
        if(subRoot == null) return true;
        if(treeRoot == null) return false;
        if(treeRoot.getData() != subRoot.getData()) return false;
        return isSubTree(treeRoot.getLeftChild(), subRoot.getLeftChild()) && isSubTree(treeRoot.getRightChild(), subRoot.getRightChild());
     }

    public static void main(String[] args) {

    }
}
