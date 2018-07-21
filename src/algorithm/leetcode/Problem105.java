package algorithm.leetcode;

public class Problem105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int pLeft, int pRight, int[] inorder, int inLeft, int inRight) {
        if (pLeft > pRight || inLeft > inRight)
            return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        int rootIdxInInorder = inLeft;
        for (; rootIdxInInorder <= inRight; rootIdxInInorder++) {
            if (inorder[rootIdxInInorder] == preorder[pLeft])
                break;
        }
        root.left = build(preorder, pLeft + 1, pLeft + rootIdxInInorder - inLeft,
                inorder, inLeft, rootIdxInInorder - 1);
        root.right = build(preorder, pLeft + rootIdxInInorder - inLeft + 1, pRight,
                inorder, rootIdxInInorder + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println();
    }
}
