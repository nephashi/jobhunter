package algorithm.nowcode;

import java.util.Scanner;

public class CangBaoTu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String y = sc.nextLine();
        String x = sc.nextLine();
        int p = 0;
        for (int i = 0; i < y.length(); i++) {
            if (x.charAt(p) == y.charAt(i)) {
                p++;
            }
            if (p == x.length()) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

}
