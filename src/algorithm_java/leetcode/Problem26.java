package algorithm.leetcode;

public class Problem26 {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            while (nums[i] == nums[i + 1] && i < length - 1) {
                for (int j = i + 1; j < length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                length--;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        int l = removeDuplicates(nums);
        System.out.println();
    }

}
