package algorithm.nowcode;

import java.util.Scanner;

public class ShangKeShuiJiao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] score = new int[n];
        boolean[] wake = new boolean[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wake[i] = sc.nextInt() == 1 ? true : false;
        }
        int[] wakeForeSum = new int[n];
        int[] wakeBackSum = new int[n];
        int[] sum = new int[n];

        wakeForeSum[0] = wake[0] == true ? score[0] : 0;
        sum[0] = score[0];

        for (int i = 1; i < n; i++) {
            if (wake[i] == true)
                wakeForeSum[i] = wakeForeSum[i - 1] + score[i];
            else
                wakeForeSum[i] = wakeForeSum[i - 1];
            sum[i] = sum[i - 1] + score[i];
        }
        wakeBackSum[n - 1] = wake[n - 1] == true ? score[n - 1] : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (wake[i] == true)
                wakeBackSum[i] = wakeBackSum[i + 1] + score[i];
            else
                wakeBackSum[i] = wakeBackSum[i + 1];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int a = i == 0 ? 0 : wakeForeSum[i - 1];
            int b = (i + k - 1) >= (n - 1) ? 0 : wakeBackSum[i + k];
            int c = i + k - 1 >= n ? sum[n - 1] : sum[i + k - 1];
            int d = i == 0 ? 0 : sum[i - 1];
            int sco =  a + b + c - d;
            if (sco > max)
                max = sco;
        }
        System.out.println(max);
    }

}
