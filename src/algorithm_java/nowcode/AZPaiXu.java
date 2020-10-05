package algorithm.nowcode;

import java.util.Scanner;

//这题变态难https://www.nowcoder.com/discuss/93285?type=0&order=0&pos=15&page=0
public class AZPaiXu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        if (k > dp[n][m]) {
            System.out.println(-1);
        } else {
            int n1 = n;
            int m1 = m;
            for (int i = 0; i < n + m; i++) {
                if (n1 > 0 && dp[n1 - 1][m1] >= k) {
                    sb.append('a');
                    n1--;
                } else {
                    if (n1 >= 1)
                        k -= dp[n1 - 1][m1];
                    sb.append('z');
                    m1--;
                }
            }
        }
        System.out.println(sb.toString());
    }

}
