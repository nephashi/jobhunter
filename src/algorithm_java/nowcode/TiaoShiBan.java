package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiaoShiBan {

    public static List<Integer> getYueShu(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i <= m) {
                list.add(i);
                if (n / i != i && (n / i) <= m) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[m + 1];
        for (int i = 0; i <= m; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[n] = 0;
        for (int i = n; i <= m; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                List<Integer> yueShu = getYueShu(i, m);
                for (int j : yueShu) {
                    if (i + j <= m)
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[m]);
        }
    }

}
