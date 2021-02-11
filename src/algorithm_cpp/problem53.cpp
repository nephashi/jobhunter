class Solution {
public:

    int maxSubArray(vector<int> & nums) {
	int dp[nums.size()];
	dp[0] = nums[0];
	for (int i = 0; i < nums.size(); i++) {
	    dp[i] = 0;
	}
	dp[0] = nums[0];
	int max = nums[0];
	for (int i = 1; i < nums.size(); i++) {
	    dp[i] = dp[i - 1] + nums[i] > nums[i] ? dp[i - 1] + nums[i] : nums[i];
	    if (dp[i] > max)
		max = dp[i];
	}
	return max;
    }
};
