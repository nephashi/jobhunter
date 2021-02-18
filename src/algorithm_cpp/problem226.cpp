class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
	if (root == nullptr) return nullptr;
	TreeNode* newleft = invertTree(root->right);
	TreeNode* newright = invertTree(root->left);
	root->left = newleft;
	root->right = newright;
	return orrt;
    }
};
