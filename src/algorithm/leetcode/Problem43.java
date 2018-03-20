package algorithm.leetcode;

public class Problem43 {

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pos1 = i + j + 1;
                int pos2 = i + j;
                pos[pos1] += mul % 10;
                pos[pos2] += mul / 10;
            }
            int carry = 0;
            for (int j = m + n - 1; j >= 0; j--) {
                pos[j] += carry;
                if (pos[j] >= 10) {
                    carry = pos[j] / 10;
                    pos[j] = pos[j] % 10;
                } else {
                    carry = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String ans = multiply("123", "45");
        System.out.println();
    }
}
