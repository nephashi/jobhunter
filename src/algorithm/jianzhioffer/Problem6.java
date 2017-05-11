package algorithm.jianzhioffer;

/**
 * 使用前序，中序遍历的结果重建二叉树
 */
public class Problem6 {

    public BinaryTreeNode<Integer> construct(int[] preOrder, int[] inOrder) {
        if(preOrder == null || inOrder == null) return null;
        try {
            return constructCore(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BinaryTreeNode<Integer> constructCore(int[] preOrder, int[] inOrder, int preOrderStart, int preOrderEnd,
                                                 int inOrderStart, int inOrderEnd) throws Exception{
        int rootValue = preOrder[preOrderStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootValue, null, null);
        if(preOrderStart == preOrderEnd) {
            if(inOrderStart == inOrderEnd && preOrder[preOrderStart] == inOrder[inOrderStart]) {
                return root;
            } else {
                throw new Exception("invalid input!");
            }
        }
        int tmpInOrder = inOrderStart;
        while (tmpInOrder <= inOrderEnd && inOrder[tmpInOrder] != rootValue ) {
            tmpInOrder++;
        }
        if(tmpInOrder == inOrderEnd + 1) {
            throw new Exception("invalid input!");
        }
        int leftLenth = tmpInOrder - inOrderStart;
        int rightLenth = inOrderEnd - tmpInOrder;
        if(leftLenth > 0)
            root.setLeftChild(constructCore(preOrder, inOrder, preOrderStart + 1, preOrderStart + leftLenth, inOrderStart, tmpInOrder - 1));
        if(rightLenth > 0)
            root.setRightChild(constructCore(preOrder, inOrder, preOrderStart + leftLenth + 1, preOrderEnd, tmpInOrder + 1, inOrderEnd));
        return root;
    }

    public static void main(String[] args) {
        Problem6 p = new Problem6();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTreeNode<Integer> n = p.construct(pre,in);
        System.out.println(1);
    }
}
