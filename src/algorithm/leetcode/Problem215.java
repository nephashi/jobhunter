package algorithm.leetcode;

public class Problem215 {

    public static int partition(int[] nums, int left, int right) {
        int l = left, r = right;
        int benchmark = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= benchmark) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] >= benchmark) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = benchmark;
        return l;
    }

    public static int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = partition(nums, l, r);
            if (m == k - 1) {
                return nums[m];
            } else if (m < k - 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
}
