package algorithm.nowcode;

import java.util.Scanner;

public class ZuiDaDeJiYueShu {

    public static long sum(long n) {
        if (n == 1)
            return 1;
        long an = 0, num = n / 2;
        if (n % 2 != 0) {
            an = n;
            num++;
        } else {
            an = n - 1;
        }
        return (1 + an) * num / 2 + sum(n / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(sum(n));
    }

}
