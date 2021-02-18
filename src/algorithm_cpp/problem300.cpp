class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
	vector<int> dp(nums.size(), 0);
	dp[0] = 1;
    int rt = 1;
	for (int i = 1; i < nums.size(); i++) {
	    dp[i] = 1;
	    for (int j = 0; j < i; j++) {
		if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
		    dp[i] = dp[j] + 1;
		}
	    }
	    if (dp[i] > rt) rt = dp[i];
	}
    for (int i = 0; i < nums.size(); i++) cout << dp[i] << ",";
	return rt;
		
    }
};
