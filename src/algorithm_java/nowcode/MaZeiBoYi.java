package algorithm.nowcode;

import java.util.Scanner;

public class MaZeiBoYi {

    public static int[] solve(int[] golds) {
        int[] sum = new int[golds.length];
        int[][] dp = new int[golds.length][golds.length];

        sum[0] = golds[0];
        dp[0][0] = golds[0];
        for (int i = 1; i < golds.length; i++) {
            sum[i] = sum[i - 1] + golds[i];
            dp[i][i] = golds[i];
        }

        for (int len = 2; len <= golds.length; len++) {
            for (int i = 0; i < golds.length; i++) {
                if (i + len - 1 < golds.length) {
                    int antiGold = Math.min(dp[i][i + len - 2], dp[i + 1][i + len - 1]);
                    int summ = i == 0 ? sum[i + len - 1] : sum[i + len - 1] - sum[i - 1];
                    dp[i][i + len - 1] = summ - antiGold;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = dp[0][golds.length - 1];
        ans[1] = Math.min(dp[0][golds.length - 2], dp[1][golds.length - 1]);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            int[] nums = new int[num];
            for (int j = 0; j < num; j++) {
                nums[j] = sc.nextInt();
            }
            int[] ans = solve(nums);
            System.out.println("Case #" + i + ": " + ans[0] + " " + ans[1]);
        }

    }

}
