package algorithm.nowcode;

import java.util.Scanner;

public class ZhengShuJiaFa {

    public static String add(String num1, String num2) {
        if (num1.length() > num2.length()) {
            StringBuilder pre = new StringBuilder();
            for (int i = 0; i < num1.length() - num2.length(); i++)
                pre.append("0");
            pre.append(num2);
            num2 = pre.toString();
        } else if (num1.length() < num2.length()) {
            StringBuilder pre = new StringBuilder();
            for (int i = 0; i < num2.length() - num1.length(); i++)
                pre.append("0");
            pre.append(num1);
            num1 = pre.toString();
        }

        int[] carry = new int[num1.length() + 1];
        int[] sum = new int[num1.length() + 1];

        int i = 0;
        for (; i < num1.length(); i++) {
            int s = num1.charAt(num1.length() - i - 1) - '0' + num2.charAt(num2.length() - i - 1) - '0' + carry[num1.length() - i];
            sum[num1.length() - i] = s % 10;
            carry[num1.length() - i - 1] = s / 10;
        }
        sum[0] = carry[0];

        boolean start = false;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < sum.length; i++) {
            if (sum[i] != 0)
                start = true;
            if (start == true) {
                sb.append("" + sum[i]);
            }
        }
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.split(" ");
        for (String n : nums) {
            for (int i = 0; i < n.length(); i++) {
                if (!Character.isDigit(n.charAt(i))) {
                    System.out.println("error");
                    return;
                }
            }
        }
        System.out.println(add(nums[0], nums[1]));
    }
}
