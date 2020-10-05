package algorithm.nowcode;

import java.util.Scanner;

public class ZuiQiangDaNao {

    public static boolean isSubString(String s, String sub, int index) {
        for (int i = 0; i < sub.length(); i++) {
            if (s.charAt(index + i) != sub.charAt(i))
                return false;
        }
        return true;
    }

    public static boolean isBackSubString(String s, String sub, int index) {
        for (int i = 0; i < sub.length(); i++) {
            if (s.charAt(index - i) != sub.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.nextLine().trim();
        String a = sc.nextLine().trim();
        String b = sc.nextLine().trim();

        boolean forward = false, back = false;

        // forward
        for (int i = 0; i <= seq.length() - a.length() - b.length(); i++) {
            if (isSubString(seq, a, i)) {
                for (int j = i + a.length(); j <= seq.length() - b.length(); j++) {
                    if (isSubString(seq, b, j)) {
                        forward = true;
                        break;
                    }
                }
                if (forward)
                    break;
            }
        }

        // backward
        for (int i = seq.length() - 1; i >= a.length() + b.length() - 1; i--) {
            if (isBackSubString(seq, a, i)) {
                for (int j = i - a.length(); j >= b.length() - 1; j--) {
                    if (isBackSubString(seq, b, j)) {
                        back = true;
                        break;
                    }
                }
                if (back)
                    break;
            }
        }

        if (forward && back) {
            System.out.println("both");
        } else if (forward) {
            System.out.println("forward");
        } else if (back) {
            System.out.println("backward");
        } else {
            System.out.println("invalid");
        }
    }

}
