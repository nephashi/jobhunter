package algorithm.nowcode;

import java.util.Scanner;

public class XiaoYiXiHuanDeDanCi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 'Z' || str.charAt(i) < 'A') {
                System.out.println("Dislikes");
                return;
            }
            if (i > 0 && str.charAt(i - 1) == str.charAt(i)) {
                System.out.println("Dislikes");
                return;
            }
        }
        for (int i = 0; i < str.length() - 3; i++) {
            for (int j = i + 1; j < str.length() - 2; j++) {
                for (int k = j + 1; k < str.length() - 1; k++) {
                    for (int l = k + 1; l < str.length(); l++) {
                        if (str.charAt(i) == str.charAt(k) && str.charAt(j) == str.charAt(l)) {
                            System.out.println("Dislikes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Likes");
    }
}
