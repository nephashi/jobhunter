package algorithm.nowcode;

import java.util.Scanner;

public class XingYunShu {

    public static int numOfOne(int n) {
        int count=0;
        while(n != 0) {
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            int ii = numOfOne(i);
            if (ii == sum)
                count++;
        }
        System.out.println(count);
    }

}
