package algorithm.nowcode;

public class FengKouDeZhu {

    public static int getMax(int[] prices, int start, int end) {
        int minPrice = prices[start];
        int maxProfit = 0;
        for (int i = start + 1; i <= end; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }

    public static int calculateMax(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = getMax(prices, 0, i) + getMax(prices, i + 1, prices.length - 1);
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(calculateMax(new int[]{3,8,5,1,7,8}));
    }

}
