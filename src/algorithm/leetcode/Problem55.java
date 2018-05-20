package algorithm.leetcode;

public class Problem55 {
    public static boolean canJump(int[] nums) {
        if (nums.length == 0)
            return true;
        int target = nums.length - 1;
        int max = nums[0];
        int cur_dist = nums[0];
        for (int i = 1; i <= target; i++) {
            if (i > cur_dist) {
                if (max >= i)
                    cur_dist = max;
                else
                    return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= target) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        canJump(new int[]{3,2,1,0,4});
    }
}
