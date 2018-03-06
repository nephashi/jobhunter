package algorithm.leetcode;

public class Problem33 {

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int benchmark = nums[0];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= benchmark) {
                if (target >= nums[0] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        int index = search(nums,4);
    }

}
