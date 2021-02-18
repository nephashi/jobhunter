class Solution {
private:
    void printmatrix(vector<vector<int>>& matrix) {
	cout << "----------";
	for (int i = 0; i < matrix.size(); i++) {
	    for (int j = 0; j < matrix[0].size(); j++)
		cout << matrix[i][j] << ",";
	    cout << endl;
	}
	cout << "----------";
    }

public:
    bool canPartition(vector<int>& nums) {
	int target = 0;
	for (int i = 0; i < nums.size(); i++) {
	    target += nums[i];
	}
	if (target % 2 != 0) return false;
	target /= 2;
	vector<vector<int>> dp(nums.size(), vector<int>(target + 1, 0));
	for (int i = 0; i < nums.size(); i++) {
	    dp[i][0] = 1;
	    if (nums[i] <= target)
	        dp[i][nums[i]] = 1;
	}
	printmatrix(dp);
	for (int i = 0; i < nums.size(); i++) {
	    for (int j = 0; j < target + 1; j++) {
		if (nums[i] <= j) {
		    if (dp[i - 1][j - nums[i]] == 1 || dp[i - 1][j] == 1) dp[i][j] = 1;
		} else {
		    if (dp[i - 1][j] == 1) dp[i][j] = 1;
		}
	    }
	}
	return dp[nums.size() - 1][target];
    }
};
