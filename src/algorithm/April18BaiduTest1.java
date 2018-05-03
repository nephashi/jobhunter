package algorithm;

import java.util.Scanner;

public class April18BaiduTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String input = sc.nextLine();
        int upperCount = 0, lowerCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))) {
                upperCount++;
            } else {
                lowerCount++;
            }
        }

        StringBuffer sb = new StringBuffer();
        if (upperCount > lowerCount) {
            for (int i = 0; i < input.length(); i++) {
                if(Character.isLowerCase(input.charAt(i))) {
                    sb.append(Character.toUpperCase(input.charAt(i)));
                } else {
                    sb.append(input.charAt(i));
                }
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (Character.isUpperCase(input.charAt(i))) {
                    sb.append(Character.toLowerCase(input.charAt(i)));
                } else {
                    sb.append(input.charAt(i));
                }
            }
        }
        String ans = sb.toString();
        System.out.print(ans);
    }
}
