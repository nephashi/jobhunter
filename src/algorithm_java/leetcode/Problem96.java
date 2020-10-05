package algorithm.leetcode;

public class Problem96 {
    public static int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
