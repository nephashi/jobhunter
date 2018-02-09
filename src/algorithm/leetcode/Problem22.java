package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        innerGenerate(0, n, 0, 0, sb, result);
        return result;
    }

    public static void innerGenerate(int curPos, int n, int curBracketCount, int curAntiBracketCount,
                                     StringBuffer curStr, List<String> result) {
        if (curPos == 2 * n) {
            result.add(curStr.toString());
            return;
        }
        if (curBracketCount < n) {
            StringBuffer sb1 = new StringBuffer(curStr.toString());
            sb1.append("(");
            innerGenerate(curPos + 1, n, curBracketCount + 1, curAntiBracketCount, sb1, result);
        }
        if (curAntiBracketCount < curBracketCount) {
            StringBuffer sb2 = new StringBuffer(curStr.toString());
            sb2.append(")");
            innerGenerate(curPos + 1, n, curBracketCount, curAntiBracketCount + 1, sb2, result);
        }
    }

    public static void main(String[] args) {
        List<String> rst = generateParenthesis(2);
        System.out.println();
    }

}
