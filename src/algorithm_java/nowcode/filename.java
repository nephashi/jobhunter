package algorithm.nowcode;

import java.util.Scanner;

public class filename {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] sp = line.split("/");
        String[] sr = sp[sp.length - 1].split("\\.");
        if (sr.length == 1) {
            System.out.println("null");
        } else {
            System.out.println(sr[sr.length - 1]);
        }
    }

}
