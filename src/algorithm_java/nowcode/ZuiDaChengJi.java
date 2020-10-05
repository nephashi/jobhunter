package algorithm.nowcode;

import java.util.Scanner;

public class ZuiDaChengJi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        maxDp[0][0] = nums[0];
        minDp[0][0] = nums[0];

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], nums[i]);
            minDp[i][0] = Math.min(minDp[i - 1][0], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j != i) {
                    maxDp[i][j] = Math.max(minDp[i - 1][j - 1] * nums[i],
                            Math.max(maxDp[i - 1][j - 1] * nums[i], maxDp[i - 1][j]));
                    minDp[i][j] = Math.min(minDp[i - 1][j - 1] * nums[i],
                            Math.min(maxDp[i - 1][j - 1] * nums[i], minDp[i - 1][j]));
                } else {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j - 1] * nums[i], minDp[i - 1][j - 1] * nums[i]);
                    minDp[i][j] = Math.min(maxDp[i - 1][j - 1] * nums[i], minDp[i - 1][j - 1] * nums[i]);
                }
                if (maxDp[i][j] > max)
                    max = maxDp[i][j];
            }
        }
        System.out.println(max);
    }

}
