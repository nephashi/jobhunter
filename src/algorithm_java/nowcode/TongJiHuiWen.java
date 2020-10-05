package algorithm.nowcode;

import java.util.Scanner;

public class TongJiHuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= line1.length(); i++) {
            String part1 = line1.substring(0,i);
            String part2 = line1.substring(i, line1.length());
            StringBuilder sb = new StringBuilder(part1);
            sb.append(line2);
            sb.append(part2);
            if (sb.toString().equals(sb.reverse().toString()))
                count++;
        }
        System.out.println(count);
    }
}
