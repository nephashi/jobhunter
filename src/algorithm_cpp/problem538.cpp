class Solution {
public:
    TreeNode* search(TreeNode* curnode, int& curval) {
	if (curnode == nullptr) return nullptr;
	TreeNode* right = search(curnode->right, curval);
	curval += curnode->val;
	TreeNode* cur = new TreeNode(curval);
	TreeNode* left = search(curnode->left, curval);
	cur->left = left;
	cur->right = right;
	return cur;
    }

    TreeNode* convertBST(TreeNode* root) {
	int curval = 0;
	return search(root, curval);
    }
};
