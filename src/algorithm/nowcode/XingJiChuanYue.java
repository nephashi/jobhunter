package algorithm.nowcode;

import java.util.Scanner;

public class XingJiChuanYue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        long x = (long)Math.sqrt(n);
        if (x * (x + 1) <= n)
            System.out.println(x);
        else
            System.out.println(x - 1);
    }

}
