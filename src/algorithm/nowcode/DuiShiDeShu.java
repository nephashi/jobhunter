package algorithm.nowcode;

import java.util.Scanner;

public class DuiShiDeShu {

    public static void main(String[] args) {
        int[] nums = new int[10000];
        int a = 0, b = 0, c = 0, count = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9997; i++) {
            int tmp = sc.nextInt();
            nums[tmp - 1] = tmp;
        }
        for (int i = 0; i < 10000; i++) {
            if (nums[i] == 0) {
                if (count == 0) {
                    a = i + 1;
                } else if (count == 1) {
                    b = i + 1;
                } else if (count == 2) {
                    c = i + 1;
                    break;
                }
                count++;
            }
        }
        String s = "" + a + b + c;
        long v = Long.parseLong(s);
        System.out.println(v % 7);
    }

}
