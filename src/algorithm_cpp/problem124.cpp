/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxGain(TreeNode* node, int& rt) {
	if (root == nullptr)
	    return 0;
	int leftGain = max(maxGain(node->left, rt), 0);
	int rightGain = max(maxGain(node->right, rt), 0);
	if (leftGain + rightGain + node->val > rt)
	    rt = leftGain + rightGain + node->val;
	return max(node->val + leftGain, node->val + rightGain);
    }
	

    int maxPathSum(TreeNode* root) {
	int rt = root->val;
	maxGain(root, rt);
	return rt;
    }
};
