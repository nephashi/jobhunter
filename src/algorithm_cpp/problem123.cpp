class Solution {
public:
    int maxProfit(vector<int>& prices) {
	vector<int> buy1(prices.size(), 0);
	vector<int> sell1(prices.size(), 0);
	vector<int> buy2(prices.size(), 0);
	vector<int> sell2(prices.size(), 0);
	buy1[0] = -1 * prices[0];
	sell1[0] = 0;
	buy2[0] = -1 * prices[0];
	sell2[0] = 0;
	for (int i = 1; i < prices.size(); i++) {
	    buy1[i] = max(buy1[i - 1], -1 * prices[i]);
	    sell1[i] = max(sell1[i - 1], buy1[i - 1] + prices[i]);
	    buy2[i] = max(buy2[i - 1], sell1[i - 1] - prices[i]);
	    sell2[i] = max(sell2[i - 1], buy2[i - 1] + prices[i]);
	}
	return max(sell1[prices.size() - 1], sell2[prices.size() - 1]);
    }
};
