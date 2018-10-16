package algorithm.nowcode;

import java.util.Scanner;

public class WangGeZouFa {

    public static long combination(int total, int k) {
        long p = 1;
        for (int i = 0; i < k; i++) {
            p *= (total - i);
        }
        for (int i = 1; i <= k; i++) {
            p /= i;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(combination(m + n, m));
    }

}
