class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
	vector<int> rt;
	if (root == nullptr) return rt;
	stack<TreeNode*> stack;
	stack.push(root);
	TreeNode * cur = root;
	while (!stack.empty()) {
	    while(cur != nullptr) {
		rt.push_back(cur->val);
		stack.push(cur);
		cur = cur->left;
	    }
	    TreeNode* top = stack.top();
	    stack.pop();
	    cur = top->right;
	}
	return rt;
    }
};
