package algorithm.leetcode;

public class Problem50 {

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);
            else
                return 1.0 / myPow(x, -n);
        }
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,2));
    }
}
