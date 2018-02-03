package algorithm.leetcode;

import java.util.*;

public class Problem17 {

    public static List<String> letterCombinations(String digits) {
        List<List<String>> dic = new ArrayList<>();
        dic.add(new ArrayList<>(Arrays.asList("0")));
        dic.add(new ArrayList<>(Arrays.asList("1")));
        dic.add(new ArrayList<>(Arrays.asList("a", "b", "c")));
        dic.add(new ArrayList<>(Arrays.asList("d", "e", "f")));
        dic.add(new ArrayList<>(Arrays.asList("g", "h", "i")));
        dic.add(new ArrayList<>(Arrays.asList("j", "k", "l")));
        dic.add(new ArrayList<>(Arrays.asList("m", "n", "o")));
        dic.add(new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        dic.add(new ArrayList<>(Arrays.asList("t", "u", "v")));
        dic.add(new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        List<String> rst = new ArrayList<>();
        if (digits.length() == 0) {
            return rst;
        }
        innerCombination(digits, dic, 0, new StringBuffer(), rst);
        return rst;
    }

    static void innerCombination(String digits, List<List<String>> dic, int curIdx, StringBuffer curString, List<String> result) {
        if (curIdx == digits.length()) {
            result.add(curString.toString());
            return;
        }
        int tmp = Integer.valueOf(String.valueOf(digits.charAt(curIdx)));
        List<String> nextChrs = dic.get(Integer.valueOf(String.valueOf(digits.charAt(curIdx))));
        for (int i = 0; i < nextChrs.size(); i++) {
            StringBuffer sb = new StringBuffer(curString.toString());
            sb.append(nextChrs.get(i));
            innerCombination(digits, dic, curIdx + 1, sb, result);
        }
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
