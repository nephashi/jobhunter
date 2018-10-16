package algorithm.nowcode;

import java.util.Scanner;

public class DaiShuGuoHe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++)
            nums[i] = sc.nextInt();

        int max = nums[0];
        int now = nums[0];
        int count = 1;
        for (int i = 0; i < T; i++) {
            if (i > now) {
                if (max < i) {
                    System.out.println(-1);
                    return;
                }
                count++;
                now = max;
                if (now >= T + 1) {
                    System.out.println(count);
                    return;
                }
            }
            if (i + nums[i] > max)
                max = i + nums[i];
        }
        System.out.println(count + 1);
    }

}
