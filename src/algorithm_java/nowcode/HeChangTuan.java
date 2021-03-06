package algorithm.nowcode;

import java.util.Scanner;

public class HeChangTuan {

    // 这种在数组里找几个乘积最大，并且强调位置关系的都可以用这种方案
    // 所谓强调位置关系，例如位置必须相邻，位置不能间隔太大等
    // dp[i][j]表示用j个数做乘法，其中最后一个数的下标是i，这种情况下最大/最小的乘积是什么
    // 如果不强调位置关系dp[i][j]可以改为
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int d = sc.nextInt();

        long[][] maxDp = new long[n][k];
        long[][] minDp = new long[n][k];

        for (int i = 0; i < n; i++) {
            maxDp[i][0] = array[i];
            minDp[i][0] = array[i];
        }

        Long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k; j++) {
                for (int l = Math.max(i - d, 0); l < i; l++) {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[l][j - 1] * array[i]);
                    maxDp[i][j] = Math.max(maxDp[i][j], minDp[l][j - 1] * array[i]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[l][j - 1] * array[i]);
                    minDp[i][j] = Math.min(minDp[i][j], maxDp[l][j - 1] * array[i]);
                }
            }
            max = Math.max(maxDp[i][k - 1], max);
        }
        System.out.println(max);
    }
}