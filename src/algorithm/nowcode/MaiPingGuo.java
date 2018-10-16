package algorithm.nowcode;

import java.util.Scanner;

public class MaiPingGuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                if (i + 6 <= n)
                    dp[i + 6] = Math.min(dp[i + 6], dp[i] + 1);
                if (i + 8 <= n)
                    dp[i + 8] = Math.min(dp[i + 8], dp[i] + 1);
            }
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }

}
