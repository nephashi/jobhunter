package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem139 {

    public static boolean dicContain(List<String> dic, String target) {
        for (int i = 0; i < dic.size(); i++)
            if (dic.get(i).equals(target))
                return true;
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && dicContain(wordDict, s.substring(j + 1, i + 1))) {
                    flag = true;
                    break;
                }
            }
            dp[i] = flag || dicContain(wordDict, s.substring(0, i + 1));
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        List<String> dic = new ArrayList<>();
        dic.add("pen");
        dic.add("apple");
        System.out.println(wordBreak("applepenapple", dic));
    }

}
