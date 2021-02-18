class Solution {
public:
    int numSquares(int n) {
	vector<int> dp(n + 1, 0);
	unordered_set<int> squares;
	for (int i = 1; i < sqrt(n) + 1; i++) squares.insert(i * i);
	for (int i = 1; i <=n; i++) {
	    dp[i] = i;
	    for (int square: squares) {
		if (square <= i) {
		    if (dp[i - square] + 1 < dp[i]) dp[i] = dp[i - square] + 1;
		}
	    }
	}
	return dp[n];	
    }
};
