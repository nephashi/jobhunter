package algorithm.leetcode;

public class Problem28 {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0 && haystack.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i == haystack.length() - needle.length() + 1) {
                return -1;
            }
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int p = strStr("aab", "abbab");
        System.out.println();
    }
}
