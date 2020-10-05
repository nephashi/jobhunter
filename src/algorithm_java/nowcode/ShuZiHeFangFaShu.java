package algorithm.nowcode;

import java.util.Scanner;

// 这题本质上和拼凑面额是一样的
public class ShuZiHeFangFaShu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //dp[i][j]:考虑前i个数，和为j有几种
        long[][] dp = new long[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1])
                    // 用或者不用第i个数，那么就是dp[i - 1][j - nums[i]]和dp[i - 1][j]
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                else
                    // 只能不用
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[n][sum]);

    }

}
