package algorithm.nowcode;

import java.util.Arrays;
import java.util.Scanner;

public class XingYunDeDaiZi {

    private static int count = 0;

    public static void DFS(int[] nums, boolean[] used, int sum, int product, int curIdx) {
        if (curIdx > nums.length)
            return;
        for (int i = curIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false)
                continue;
            used[i] = true;
            sum += nums[i];
            product *= nums[i];
            if (sum > product) {
                count++;
                DFS(nums, used, sum, product, i + 1);
            } else {
                if (sum == 1 && product == 1)
                    DFS(nums, used, sum, product, i + 1);
            }
            used[i] = false;
            sum -= nums[i];
            product /= nums[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        DFS(nums, used, 0, 1, 0);
        System.out.println(count);
    }

}
