package algorithm.leetcode;

public class Problem312 {

    public static int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] virtualNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++)
            virtualNums[i + 1] = nums[i];
        virtualNums[0] = 1;
        virtualNums[nums.length + 1] = 1;

        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = virtualNums[i] * virtualNums[i + 1] * virtualNums[i + 2];
        }

        for (int len = 2; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int max = 0;
                for (int k = start; k <= start + len - 1; k++) {
                    int prev = k == start ? 0 : dp[start][k - 1];
                    int after = k == start + len - 1 ? 0 : dp[k + 1][start + len - 1];
                    int multi = virtualNums[start] * virtualNums[start + len + 1] * virtualNums[k + 1];
                    int value = prev + after + multi;
                    if (value > max)
                        max = value;
                }
                dp[start][start + len - 1] = max;
            }
        }
        return dp[0][nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }

}
