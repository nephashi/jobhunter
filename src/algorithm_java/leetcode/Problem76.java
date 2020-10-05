package algorithm.leetcode;

public class Problem76 {

    public static String minWindow(String S, String T) {
        int[] srcHash = new int[256];
        int[] dstHash = new int[256];
        for (int i = 0; i < T.length(); i++) {
            srcHash[T.charAt(i)]++;
        }

        int found = 0;
        int begin = -1, end = -1, minLen = S.length();
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            dstHash[S.charAt(i)]++;
            if (dstHash[S.charAt(i)] <= srcHash[S.charAt(i)]) {
                found++;
            }
            if (found == T.length()) {
                // 收缩
                while (start < i && dstHash[S.charAt(start)] > srcHash[S.charAt(start)]) {
                    dstHash[S.charAt(start)]--;
                    start++;
                }
                if (i - start < minLen) {
                    minLen = i - start;
                    begin = start;
                    end = i;
                }
                dstHash[S.charAt(start)]--;
                found--;
                start++;
            }
        }
        return begin == -1 ? "" : S.substring(begin, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ABBBBBBB", "ABC"));
    }
}
