package algorithm.nowcode;

import java.util.Scanner;

public class BuYaoEr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        if (w % 4 == 0 || h % 4 == 0)
            System.out.println(w * h / 2);
        else if (w % 2 == 0 && h % 2 == 0) {
            System.out.println(h * w / 2 + 2);
        } else {
            System.out.println(h * w / 2 + 1);
        }
    }

}
