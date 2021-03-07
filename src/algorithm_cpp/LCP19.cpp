class Solution {
public:
    int minimumOperations(string leaves) {
	int dp[leaves.size()][3];
	memset(dp, 0, sizeof(dp));
        dp[0][0] = leaves.at(0) == 'y' ? 1 : 0;
	dp[0][1] = leaves.size() + 1;
	dp[0][2] = leaves.size() + 1;
	dp[1][2] = leaves.size() + 1;
	for (int i = 1; i < leaves.size(); i++) {
	    dp[i][0] = dp[i - 1][0] + (leaves.at(i) == 'y' ? 1 : 0);
	    dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + (leaves.at(i) == 'r' ? 1 : 0);
	    if (i >= 2)
	        dp[i][2] = min(dp[i - 1][1], dp[i - 1][2]) + (leaves.at(i) == 'y' ? 1 : 0);
	}
	return dp[leaves.size() - 1][2];
	
    }
};
