package algorithm.nowcode;

import java.util.Scanner;

public class QiuShuLieDeHe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] array = new double[m];
        array[0] = n;
        for (int i = 1; i < m; i++) {
            array[i] = Math.sqrt(array[i - 1]);
        }
        double sum = 0;
        for (int i = 0; i < m; i++)
            sum += array[i];
        System.out.println(String.format("%.2f", sum));
    }

}
