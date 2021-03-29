class Solution {
private:
    int depth;
public:
    int maxDepth(TreeNode* root) {
	if (root == nullptr) reutn 0;
	depth = 1;
	search(root, 1);
	return depth;
    }

    void search(TreeNode* root, int cur) {
	if (root == nullptr) return;
	if (cur + 1 > depth) depth = cur + 1;
	search(root->left, cur + 1);
	search(root->right, cur + 1);
    }
};
