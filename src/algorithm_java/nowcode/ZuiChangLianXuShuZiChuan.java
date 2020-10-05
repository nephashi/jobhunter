package algorithm.nowcode;

import java.util.Scanner;

public class ZuiChangLianXuShuZiChuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int start = -1, maxStart = -1, maxEnd = -1;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (flag == false) {
                    flag = true;
                    start = i;
                }
                if (flag == true) {
                    if (i - start > maxEnd - maxStart) {
                        maxEnd = i;
                        maxStart = start;
                    }
                }
            } else {
                flag = false;
            }
        }
        System.out.println(s.substring(maxStart, maxEnd + 1));
    }
}
