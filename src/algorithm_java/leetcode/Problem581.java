package algorithm.leetcode;

public class Problem581 {

    public static int findUnsortedSubarray(int[] nums) {
        int begin = -1, end = -2;
        int max = nums[0], min = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[nums.length - i - 1] < min) {
                min = nums[nums.length - i - 1];
            }
            if (nums[i] < max)
                end = i;
            if (nums[nums.length - i - 1] > min)
                begin = nums.length - i - 1;
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(findUnsortedSubarray(nums));
    }

}
