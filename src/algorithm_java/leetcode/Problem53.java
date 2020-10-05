package algorithm.leetcode;

public class Problem53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int[] sum = new int[n];
        sum[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }
}
