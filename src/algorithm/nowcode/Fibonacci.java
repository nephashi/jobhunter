package algorithm.nowcode;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        long a1 = 0, a2 = 1;
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long a = a1 + a2;
        while (a < n) {
            a1 = a2;
            a2 = a;
            a = a1 + a2;
        }
        System.out.println(Math.min(n - a2, a - n));
    }

}
