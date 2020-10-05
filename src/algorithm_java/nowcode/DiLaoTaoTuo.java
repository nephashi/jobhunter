package algorithm.nowcode;

import java.util.Scanner;

public class DiLaoTaoTuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        boolean matrix[][] = new boolean[n][m];
        int locationCount = 0;
        for (int i = 0; i < n; i++) {
            String next = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (next.charAt(j) == '.') {
                    matrix[i][j] = true;
                    locationCount++;
                } else {
                    matrix[i][j] = false;
                }
            }
        }
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int numMove = sc.nextInt();
        int[][] moves = new int[numMove][2];
        for (int i = 0; i < numMove; i++) {
            moves[i][0] = sc.nextInt();
            moves[i][1] = sc.nextInt();
        }

        int dp[][] = new int[n][m];
        dp[startX][startY] = 1;
        int arrivalCount = 1;
        int max = 0;

        while (true) {
            int newArrivalCount = 0;
            int[][] dpCopy = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    dpCopy[i][j] = dp[i][j];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dpCopy[i][j] > 0 && matrix[i][j] == true) {
                        for (int k = 0; k < numMove; k++) {
                            int x = i + moves[k][0];
                            int y = j + moves[k][1];
                            if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] == true) {
                                if (dp[x][y] == 0) {
                                    dp[x][y] = dp[x][y] == 0 ? dp[i][j] + 1 : Math.min(dp[i][j] + 1, dp[x][y]);
                                    if (dp[x][y] > max)
                                        max = dp[x][y];
                                    newArrivalCount++;
                                    arrivalCount++;
                                }
                            }
                        }
                    }

                }
            }
            if (arrivalCount == locationCount) {
                System.out.println(max - 1);
                return;
            }
            if (newArrivalCount == 0) {
                System.out.println(-1);
                return;
            }
        }
    }

}
