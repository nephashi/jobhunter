package algorithm.nowcode;

import java.util.Scanner;

public class PinCouMianE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] changes = new int[]{1, 5, 10, 20, 50, 100};

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 0; i < changes.length; i++) {
            for (int j = changes[i]; j <= n; j++) {
                dp[j] += dp[j - changes[i]];
            }
        }

        System.out.println(dp[n]);
    }
}
