package algorithm.leetcode;

public class Problem136 {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)  {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,1,2,7,1,2,7};
        singleNumber(nums);
    }

}
