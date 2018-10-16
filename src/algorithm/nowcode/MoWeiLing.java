package algorithm.nowcode;

import java.util.Scanner;

public class MoWeiLing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count5 = 0;
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k % 5 == 0) {
                k /= 5;
                count5++;
            }
        }
        System.out.println(count5);
    }

}
