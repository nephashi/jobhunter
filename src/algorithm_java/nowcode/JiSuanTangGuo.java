package algorithm.nowcode;

import java.util.Scanner;

public class JiSuanTangGuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int aa = (a + c) / 2;
        int bb = (c - a) / 2;
        int cc = (d - b) / 2;

        if (aa - bb == a && bb - cc == b && aa + bb == c && bb + cc == d) {
            System.out.print((a + c) / 2 + " ");
            System.out.print((c - a) / 2 + " ");
            System.out.print((d - b) / 2);
        } else {
            System.out.println("No");
        }


    }

}
