package algorithm;

import java.util.Scanner;

public class March29AlibabaTest {

    static boolean maxComponent(int a, int b) {
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        int num = sc.nextInt();

        int count = 0;
        for (int x = 1; x < num; x++) {
            for (int y = x + 1; y <= num; y++) {
                if (x == 1 || !maxComponent(x, y)) {
                    count++;
                }
            }
        }
        int ans = (count + 1) * 2 + 1;
        System.out.println(ans);

    }

}
