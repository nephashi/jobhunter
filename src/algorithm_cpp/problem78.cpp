class Solution {
public:
    void dfs(vector<int>& nums, int cur_idx, vector<int> cur, vector<vector<int>>& ans) {
	if (cur_idx >= nums.size()) 
	    return;
	for (int i = cur_idx; i < nums.size(); i++) {
	    cur.push_back(nums[i]);
	    ans.push_back(cur);
	    dfs(nums, i + 1, cur, ans);
	    cur.pop_back();
	}
    }
	

    vector<vector<int>> subsets(vector<int>& nums) {
	vector<vector<int>> ans;
	ans.push_back(vector<int>{});
	dfs(nums, 0, vector<int>{}, ans);
	return ans;
    }
};
