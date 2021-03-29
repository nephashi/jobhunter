class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if (k == 0) return 0;
	int n = prices.size();
	k = min(k, n / 2);
	vector<vector<int>> sells(n, vector<int>(k, 0));
	vector<vector<int>> buys(n, vector<int>(k, 0));
	for (int i = 0; i < k; i++) buys[0][i] = prices[0] * -1;
	for (int i = 1; i < n; i++) {
	    buys[i][0] = max(buys[i - 1][0], -1 * prices[i]);
	    sells[i][0] = max(sells[i - 1][0], buys[i - 1][0] + prices[i]);
	    for (int j = 1; j < k; j++) {
		buys[i][j] = max(buys[i - 1][j], sells[i - 1][j - 1] - prices[i]);
		sells[i][j] = max(sells[i - 1][j], buys[i - 1][j] + prices[i]);
	    }
	}
	int rt = 0;
	for (int i = 0; i < k; i++) {
	    rt = max(rt, sells[n - 1][i]);
	}
	return rt;
    }
};
