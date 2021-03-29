class Solution {
private:
    map<int, int> m;

public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
	for (int i = 0; i < inorder.size(); i++) m[inorder[i]] = i;
	return build(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
    }

    TreeNode* build(const vector<int> & inorder, int instart, int inend, const vector<int> & postorder, int poststart, int postend) {
	if (instart > inend) return nullptr;
	TreeNode* root = new TreeNode(postorder[postend]);
	int pos = m[postorder[postend]];
	root->left = build(inorder, instart, pos - 1, postorder, poststart, poststart + (pos - instart) - 1);
	root->right = build(inorder, pos + 1, inend, postorder, poststart + (pos - instart), postend - 1);
	return root;
    }
	
};
