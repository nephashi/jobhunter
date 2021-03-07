class Solution {
public:
    TreeNode* buildSubTree(vector<int>& preorder, vector<int>& inorder, int prestart, int preend, int instart, int inend) {
	if (inend < instart) {
	    return nullptr;
	}
	TreeNode *node = new TreeNode(preorder[prestart]);
	int i = instart;
	while (i <= inend) {
	    if (inorder[i] == preorder[prestart]) {
		break;
	    }
	    i++;
	}
	node->left = buildSubTree(preorder, inorder, prestart + 1, prestart + i - instart, instart, i - 1);
	node->right = buildSubTree(preorder, inorder, prestart + i - instart + 1, preend, i + 1, inend);
	return node;
    }

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
	return buildSubTree(preorder, inorder, 0, preorder.size() - 1, 0, preorder.size() - 1);
    }
};
