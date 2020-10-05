package algorithm.leetcode;

public class Problem10 {
    public static boolean isMatch(String s, String p) {
        //dp[i][j] : s[0:i-1] match p[0:j-1]
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        for (int i = 0; i < sLength + 1; i++) {
            for (int j = 0; j < pLength + 1; j++)
                dp[i][j] = false;
        }
        dp[0][0] = true;
        for (int i = 1; i < pLength + 1; i++) {
            if(p.charAt(i - 1) == '*' && dp[0][i - 2] == true)
                dp[0][i] = true;
        }
        for (int i = 1; i < sLength + 1; i++) {
            for(int j = 1; j < pLength + 1; j++) {
                if(p.charAt(j - 1) != '*' && p.charAt(j - 1) != '.') {
                    if(s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                }
                if(p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

}
