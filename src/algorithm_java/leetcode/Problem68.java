package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem68 {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        int curWordIdx = 0;
        List<String> ans = new ArrayList<>();

        while (curWordIdx < words.length) {
            int spaceCount = 0;
            int startWordIdx = curWordIdx;

            while (true) {
                if (curWordIdx < words.length &&
                        spaceCount + words[curWordIdx].length() <= maxWidth) {
                    spaceCount += words[curWordIdx].length() + 1;
                    curWordIdx++;
                } else {
                    break;
                }
            }

            int characCount = 0;
            for (int i = startWordIdx; i < curWordIdx; i++) {
                characCount += words[i].length();
            }

            StringBuffer sb = new StringBuffer();

            if (curWordIdx - startWordIdx > 1) {
                if (curWordIdx != words.length) {
                    int[] intervalBlank = new int[curWordIdx - startWordIdx - 1];
                    int basicNumBlank = (maxWidth - characCount) / (curWordIdx - startWordIdx - 1);
                    int additionNumBlank = (maxWidth - characCount) % (curWordIdx - startWordIdx - 1);
                    for (int i = 0; i < intervalBlank.length; i++) {
                        intervalBlank[i] = (i < additionNumBlank) ? basicNumBlank + 1 : basicNumBlank;
                    }

                    for (int i = startWordIdx; i < curWordIdx; i++) {
                        sb.append(words[i]);
                        if (i != curWordIdx - 1) {
                            for (int j = 0; j < intervalBlank[i - startWordIdx]; j++)
                                sb.append(" ");
                        }
                    }

                } else {
                    for (int i = startWordIdx; i < curWordIdx; i++) {
                        sb.append(words[i]);
                        if (i != curWordIdx - 1) {
                            sb.append(" ");
                        }
                    }
                    for (int i = 0; i < maxWidth - characCount - (curWordIdx - startWordIdx - 1); i++) {
                        sb.append(" ");
                    }
                }
            } else {
                sb.append(words[startWordIdx]);
                for (int i = 0; i < maxWidth - words[startWordIdx].length(); i++) {
                    sb.append(" ");
                }
            }
            ans.add(sb.toString());
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[] {
                "What","must","be","acknowledgment","shall","be"
        }, 16));
    }

}
