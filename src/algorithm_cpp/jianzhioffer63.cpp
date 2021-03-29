class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if (prices.size() == 0) return 0;
        int low = prices[0];
        int profit = 0;
	for (int i = 0; i < prices.size(); i++) {
	    if (prices[i] - low > profit) profit = prices[i] - low;
	    if (prices[i] < low) low = prices[i];
	}
	return profit;
    }
};
