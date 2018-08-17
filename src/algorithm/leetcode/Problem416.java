package algorithm.leetcode;

import java.util.Arrays;

public class Problem416 {

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[half];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,5}));
    }

}
