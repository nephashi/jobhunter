package algorithm.nowcode;

import java.util.Scanner;

public class HuiWenXuLie {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(solve(arr,n));
        }
        scan.close();
    }

    private static int solve(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                arr[left + 1] += arr[left];
                ++left;
                ++ans;
            }else if (arr[left] > arr[right]){
                arr[right - 1] += arr[right];
                --right;
                ++ans;
            }else {
                ++left;
                --right;
            }
        }
        return ans;
    }

}