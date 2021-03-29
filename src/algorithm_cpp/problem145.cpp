class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
	stack<TreeNode*> stack;
	vector<int> rt;
	TreeNode* cur = root;
	TreeNode* prev = nullptr;
	while (!stack.empty() || cur != nullptr) {
	    while (cur != nullptr) {
		stack.push(cur);
		cur = cur->left;
	    }
	    TreeNode* node = stack.top();
	    stack.pop();
	    if (node->right == nullptr || node->right == prev) {
	        rt.push_back(node->val);
		prev = node;
		cur = nullptr;
	    } else {
		stack.push(node);
		cur = node->right;
	    }
	}
	return rt;
		
	    
    }
};
