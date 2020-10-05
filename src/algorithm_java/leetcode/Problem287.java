package algorithm.leetcode;

public class Problem287 {

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0, t = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) break;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

}
