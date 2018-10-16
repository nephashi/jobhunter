package algorithm.nowcode;

import java.util.Scanner;

public class ShenFenZhengFenZu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++)
            if (Character.isDigit(line.charAt(i)))
                sb.append(line.charAt(i));
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (i == 5 || i == 13)
                System.out.println(" ");
        }
    }

}
