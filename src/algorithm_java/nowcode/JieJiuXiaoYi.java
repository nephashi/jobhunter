package algorithm.nowcode;

import java.util.Scanner;

public class JieJiuXiaoYi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int trapx[] = new int[n];
        int trapy[] = new int[n];
        for (int i = 0; i < n; i++) {
            trapx[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            trapy[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (trapx[i] - 1 + trapy[i] - 1 < min)
                min = trapx[i] - 1 + trapy[i] - 1;
        }
        System.out.println(min);
    }

}
