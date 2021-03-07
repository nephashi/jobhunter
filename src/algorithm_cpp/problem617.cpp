class Solution {
public:
    TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
	if (root1 == nullptr && root2 == nullptr) return nullptr;
	TreeNode* left = mergeTrees(root1 == nullptr ? nullptr : root1->left, root2 == nullptr ? nullptr : root2->left);
	TreeNode* right = mergeTrees(root1 == nullptr ? nullptr : root1->right, root2 == nullptr ? nullptr : root2->right);
	int val = (root1 == nullptr ? 0 : root1->val) + (root2 == nullptr ? 0 : root2->val);
	TreeNode* node = new TreeNode(val);
	node->left = left;
	node->rihgt = right;
	return node;
    }
};
