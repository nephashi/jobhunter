package algorithm.leetcode;

public class Problem309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        if (prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = prices[0] * -1;
        buy[1] = prices[1] < prices[0] ? prices[1] * -1 : prices[0] * -1;
        sell[0] = 0;
        for (int i = 1; i < len; i++) {
            if (i > 1)
                buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[len - 1];
    }

}
