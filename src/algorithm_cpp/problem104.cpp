class Solution {
public:

    void traverse(TreeNode* node, int depth, int& max) {
	if (node == nullptr) return;
	if (depth > max) max = depth;
	traverse(node->left, depth + 1, max);
	traverse(node->right, depth + 1, max);
    }

    int maxDepth(TreeNode* root) {
	int max = 0;
	traverse(root, 1, max);
	return max;
	
    }
};
