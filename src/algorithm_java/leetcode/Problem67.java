package algorithm.leetcode;

public class Problem67 {

    public static String addBinary(String a, String b) {
        int len = -1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.abs(a.length() - b.length()); i++) {
            sb.append("0");
        }
        if (a.length() > b.length()) {
            len = a.length();
            b = sb.toString() + b;
        } else {
            len = b.length();
            a = sb.toString() + a;
        }

        int[] ans = new int[len];
        int[] carry = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            ans[i] = Integer.valueOf(a.substring(i, i + 1)) + Integer.valueOf(b.substring(i, i + 1)) + carry[i + 1];
            if (ans[i] == 2) {
                ans[i] = 0;
                carry[i] = 1;
            } else if(ans[i] == 3) {
                ans[i] = 1;
                carry[i] = 1;
            }
        }

        sb = new StringBuffer();
        if (carry[0] == 1)
            sb.append("1");
        for (int i = 0; i < ans.length; i++) {
            sb.append(String.valueOf(ans[i]));
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
