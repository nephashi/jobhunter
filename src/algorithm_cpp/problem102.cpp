class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
	vector<vector<int>> rt;
        if (root == nullptr)
	    return rt;
	queue <TreeNode*> q;
	q.push(root);
	while (!q.empty()) {
	    vector<int> layer;
        int tmp = q.size();
	    for (int i = 0; i < tmp; i++) {
		auto node = q.front(); q.pop();
		layer.push_back(node->val);
		if (node->left != nullptr) q.push(node->left);
		if (node->right != nullptr) q.push(node->right);
	    }
	    rt.push_back(layer);
	}
	return rt;
    }
};
