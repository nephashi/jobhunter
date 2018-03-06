package algorithm.leetcode;

public class Problem35 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] < target && nums[mid + 1] > target) {
                return mid + 1;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int ans = searchInsert(nums, 2);
        System.out.println();
    }
}
