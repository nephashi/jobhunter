package algorithm.leetcode;

public class Problem69 {

    // this is good but I will implement a better way using binary search
    public static int mySqrt1(int x) {
        long upperBound = 46341l * 46341l;
        for (int i = 0; i <= x; i++) {
            if (i == 46340 && x < upperBound) {
                return i;
            } else if (i * i <= x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return -1;
    }

    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * mid <= (long)x && (mid + 1) * (mid + 1) > (long)x) {
                return (int)mid;
            } else {
                if (mid * mid < (long)x) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(122));
    }

}
