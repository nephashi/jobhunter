package algorithm.nowcode;

import java.util.Scanner;

public class TwoWaysToSort {

    // -1 : s1小
    public static int compareLexicographically(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) < s2.charAt(i))
                return -1;
            else if (s1.charAt(i) > s2.charAt(i))
                return 1;
        }
        if (s1.length() == s2.length())
            return 0;
        if (s1.length() < s2.length())
            return -1;
        return 1;
    }

    public static int compareLength(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        boolean len = true;
        boolean lexi = true;
        for (int i = 0; i < n - 1; i++) {
            if (compareLength(strs[i], strs[i + 1]) == 1)
                len = false;
            if (compareLexicographically(strs[i], strs[i + 1]) == 1)
                lexi = false;
        }
        if (len && lexi)
            System.out.println("both");
        else if (len)
            System.out.println("lengths");
        else if (lexi)
            System.out.println("lexicographically");
        else
            System.out.println("none");
    }

}
