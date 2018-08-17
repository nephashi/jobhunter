package algorithm.leetcode;

public class Problem494 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (S > sum)
            return 0;

        int[] dpPre = new int[2001];
        int[] dpAft = new int[2001];
        dpPre[1000] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2001; j++) {
                if (dpPre[j] > 0) {
                    dpAft[j + nums[i]] += dpPre[j];
                    dpAft[j - nums[i]] += dpPre[j];
                }
            }
            for (int j = 0; j < 2001; j++) {
                dpPre[j] = dpAft[j];
                dpAft[j] = 0;
            }
        }
        return dpPre[S + 1000];
    }

}
