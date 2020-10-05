package algorithm.leetcode;

public class Problem300 {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > ans)
                        ans = dp[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println();
    }

}
