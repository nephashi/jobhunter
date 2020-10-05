package algorithm.leetcode;

public class Problem63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < height; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < width; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[height - 1][width - 1];
    }

    public static void main(String[] args) {
        int[][] ob = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(ob));
    }

}
