package algorithm.nowcode;

import java.util.Scanner;

public class PingGuoFengShou {
    public static int query(int[] sum, int query) {
        if (query <= sum[0])
            return 1;
        else {
            int l = 1, r = sum.length - 1;
            while (true) {
                int mid = (l + r) / 2;
                if (sum[mid - 1] < query && sum[mid] >= query)
                    return mid + 1;
                else if (sum[mid - 1] >= query) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + nums[i];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(query(sum, sc.nextInt()));
        }
    }
}