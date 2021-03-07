class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
	vector<int> rt;
	search(root, 1, rt);
	return rt;
    }

    void search(TreeNode* root, int depth, vector<int>& rt) {
	if (root == nullptr) return;
	if (depth > rt.size()) rt.push_back(root->val);
	search(root->right, depth + 1, rt);
	search(root->left, depth + 1, rt);
    }

};
