class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
	vector<int> dp(amount + 1, -1);
	dp[0] = 0;
	for (int i = 1; i <= amount; i++) {
	    for (int coin : coins) {
		if (coin <= i && dp[i - coin] != -1 && (dp[i - coin] + 1 < dp[i] || dp[i] == -1)) {
		    dp[i] = dp[i - coin] + 1;
		}
	    }
	}
	return dp[amount];
    }
};