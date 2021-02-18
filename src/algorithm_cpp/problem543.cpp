class Solution {
private:
    int maxlen;
public:
    int search(TreeNode* node) {
	if (node == nullptr) return 0;
	int leftlen = search(node->left);
	int rightlen = search(node->right);
	if (leftlen + rightlen + 1 > maxlen) maxlen = leftlen + rightlen + 1;
	return max(leftlen, rightlen) + 1; 
    }

    int diameterOfBinaryTree(TreeNode* root) {
	if (root == nullptr) return 0;
	maxlen = 0;
	search(root);
	return maxlen - 1;
    }
};
