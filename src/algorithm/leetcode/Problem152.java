package algorithm.leetcode;

public class Problem152 {

    public static int maxProduct(int[] nums) {
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i] = Math.max(Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]), nums[i]);
            minDp[i] = Math.min(Math.min(minDp[i - 1] * nums[i], maxDp[i - 1] * nums[i]), nums[i]);
            if (maxDp[i] > maxProduct)
                maxProduct = maxDp[i];
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
