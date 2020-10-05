package algorithm.leetcode;

public class Problem5 {
    public static String longestPalindrome(String s) {
        //dynamic programming
        int strlen = s.length();
        boolean[][] dp = new boolean[strlen][strlen];
        for (int i = 0; i < strlen; i++)
            dp[i][i] = true;
        for (int i = 0; i < strlen - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                dp[i][i+1]=true;
        }
        for (int len = 3; len <= strlen; len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                if(s.charAt(start + len - 1) != s.charAt(start))
                    dp[start][start + len - 1] = false;
                else {
                    dp[start][start + len - 1] = dp[start + 1][start + len - 2];
                }
            }
        }
        int maxlen = 0, l = 0, r = 0;
        for(int i = 0; i < strlen; i++) {
            for (int j = i; j < strlen; j++) {
                if(dp[i][j] == true && (j - i + 1 > maxlen)) {
                    maxlen = j - i + 1;
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
