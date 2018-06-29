package algorithm.leetcode;

public class Problem66 {
    public static int[] plusOne(int[] digits) {
        int[] carry = new int[digits.length + 1];
        carry[carry.length - 1] = 1;
        for (int i = 0; i < digits.length; i++) {
            digits[digits.length - i - 1] += carry[carry.length - i - 1];
            if (digits[digits.length - i - 1] >= 10) {
                carry[carry.length - i - 2] = 1;
                digits[digits.length - i - 1] = 0;
            }
        }
        int ans[] = null;
        if (carry[0] == 1) {
            ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ans[i + 1] = digits[i];
            }
        } else {
            ans = new int[digits.length];
            for (int i = 0; i < digits.length; i++) {
                ans[i] = digits[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] as = plusOne(new int[] {
                9,9,9
        });
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }
    }
}
