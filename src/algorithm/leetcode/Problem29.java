package algorithm.leetcode;

public class Problem29 {
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldividend == 0 || (ldividend < ldivisor)) return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) {
            ans = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) lans * sign;
        }
        return ans;
    }

    private static long ldivide(long dividend, long divisor) {
        if (dividend < divisor) return 0;

        int count = 1;
        long tmpDivisor = divisor;
        while (tmpDivisor + tmpDivisor < dividend) {
            tmpDivisor = tmpDivisor << 1;
            count = count << 1;
        }
        return count + ldivide(dividend - tmpDivisor, divisor);
    }

    public static void main(String[] args) {
        int ans = divide(-2147483648,1);
        System.out.println(ans);
    }
}
