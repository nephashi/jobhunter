package algorithm.leetcode;

public class Problem37 {
    public static String countAndSay(int n) {
        String cur = "1";
        for (int i = 1; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            int curIndex = 0;
            while (curIndex < cur.length()) {
                int count = 1;
                char curChar = cur.charAt(curIndex);
                while (curIndex != cur.length() - 1 && curChar == cur.charAt(curIndex + 1)) {
                    count++;
                    curIndex++;
                }
                sb.append(count);
                sb.append(curChar);
                curIndex++;
            }
            cur = sb.toString();
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
