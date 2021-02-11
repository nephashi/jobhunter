class Solution {
public:

    void traceback(vector<int>& nums, int curidx, vector<vector<int>>& res) {
	if (curidx >= nums.size()) {
	    res.push_back(cur);
	    return;
	}
	for (int i = curidx; i < nums.size(); i++) {
	    swap(nums[curidx], nums[i]);
	    traceback(nums, curidx + 1, res);
	    swap(nums[curidx], nums[i]);
	}
    }

    vector<vector<int>> permute(vector<int>& nums) {
	vector<vector<int>> res;
        backtrack(nums, 0, res );
        return res;
    }
};
