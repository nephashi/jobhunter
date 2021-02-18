class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
	int sum = 0;
	for (int i = 0; i < nums.size(); i++) {
	    sum += nums[i];
	}
	if (S > sum) return 0;
	vector<vector<int>> dp(nums.size(), vector<int>(sum * 2 + 1, 0));
	dp[0][sum + nums[0]] = 1;
	dp[0][sum - nums[0]] += 1;
	for (int i = 1; i < nums.size(); i++) {
	    for (int j = -1 * sum; j < sum + 1; j++) {
		if (j - nums[i] >= -1 * sum) {
		    dp[i][j + sum] += dp[i - 1][j - nums[i] + sum];
		}
		if (j + nums[i] <= sum) {
		    dp[i][j + sum] += dp[i - 1][j + nums[i] + sum];
		}
	    }
	}
	return dp[nums.size() - 1][S + sum];
    }
};
