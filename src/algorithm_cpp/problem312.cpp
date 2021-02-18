class Solution {
public:
    int maxCoins(vector<int>& nums) {
	if (nums.size() == 0) return 0;
	nums.insert(nums.begin(), 1);
	nums.push_back(1);
	vector<vector<int>> dp(nums.size(), vector<int>(nums.size(), 0));
	for (int len = 3; len <= nums.size(); len++) {
	    for (int start = 0; start <= nums.size() - len; start++) {
		for (int i = start + 1; i < start + len - 1; i++) {
		    int tmp = nums[i] * nums[start] * nums[start + len - 1] + dp[start][i] + dp[i][start + len - 1];
		    if (tmp > dp[start][start + len - 1])  dp[start][start + len - 1] = tmp;
		}
	    }
	}
	return dp[0][nums.size() - 1];
    }
};
