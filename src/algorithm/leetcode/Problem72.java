package algorithm.leetcode;

public class Problem72 {

    public static int arrayMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int[] tmp = new int[3];
                tmp[0] = dp[i - 1][j] + 1;
                tmp[1] = dp[i][j - 1] + 1;
                tmp[2] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                        dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = arrayMin(tmp);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance( "", "a"));
    }

}
