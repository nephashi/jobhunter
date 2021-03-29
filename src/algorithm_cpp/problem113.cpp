class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
	vector<vector<int>> rt;
	vector<int> path;
	dfs(rt, path, root, targetSum);
	return rt;	
    }

    void dfs(vector<vector<int>> & rt, vector<int> & path, TreeNode* cur, int target) {
	if (cur == nullptr) return;
	path.push_back(cur->val);
	if (target == cur->val && cur->left == nullptr && cur->right == nullptr) {
	    rt.push_back(path);
	} else {
	    dfs(rt, path, cur->left, target - cur->val);
	    dfs(rt, path, cur->right, target - cur->val);
	}
	path.pop_back();
    }
};
