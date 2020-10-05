package algorithm.leetcode;

public class Problem647 {

    public static int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            dp[i][i] = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1))
                dp[i][i + 1] = 1;
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                if (s.charAt(start) == s.charAt(start + len - 1)) {
                    dp[start][start + len - 1] = dp[start + 1][start + len - 2];
                } else {
                    dp[start][start + len - 1] = 0;
                }
            }
        }
        int count = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start <= s.length() - len; start++) {
                if (dp[start][start + len - 1] == 1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

}
