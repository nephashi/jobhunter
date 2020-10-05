package algorithm.nowcode;

import java.util.Scanner;

public class ShuZiFanZhuan {

    public static int reverse(int a) {
        int b = 0;
        boolean negative = false;
        if (a < 0) {
            negative = true;
            a = a * -1;
        }
        while (a != 0) {
            b *= 10;
            b += a % 10;
            a /= 10;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = reverse(x);
        int b = reverse(y);
        System.out.println(reverse(a + b));
    }

}
