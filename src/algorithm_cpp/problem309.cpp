class Solution {
public:
    int maxProfit(vector<int>& prices) {
	if (prices.size() == 0) return 0;
	vector<vector<int>> dp(vector<int, 3>, prices.size());
	dp[0][0] = -1 * prices[0];
	dp[0][1] = 0;
	dp[0][2] = 0;
	for (int i = 1; i < prices.size(); i++) {
	    dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
	    dp[i][1] = dp[i - 1][0] + prices[i];
	    dp[i][2] = max(dp[i - 1][1], dp[i - 1][2]);
	}
	return max(dp[i][1], dp[i][2]);
    }
};
