package algorithm.leetcode;

public class Problem238 {

    public int[] productExceptSelf(int[] nums) {
        int[] nums1 = new int[nums.length];
        int[] nums2 = new int[nums.length];
        int[] ans = new int[nums.length];
        nums1[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums1[i] = nums1[i - 1] * nums[i - 1];
        }
        nums2[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            nums2[i] = nums2[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums1[i] * nums2[i];
        }
        return ans;
    }
}
