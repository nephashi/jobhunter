package algorithm.leetcode;

public class Problem221 {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = dp[i][0] > max ? dp[i][0] : max;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = dp[0][i] > max ? dp[0][i] : max;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = dp[i][j] > max ? dp[i][j] : max;
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] m = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        maximalSquare(m);
    }
}
