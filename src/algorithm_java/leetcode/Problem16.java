package algorithm.leetcode;

import java.util.Arrays;

public class Problem16 {

    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int last = nums.length - 1;
            while (second < last) {
                if (Math.abs((nums[first] + nums[second] + nums[last] - target)) < Math.abs((result - target))) {
                    result = (nums[first] + nums[second] + nums[last]);
                }
                if (nums[first] + nums[second] + nums[last] < target) {
                    second++;
                } else if (nums[first] + nums[second] + nums[last] > target) {
                    last--;
                } else {
                    return target;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,10,11};
        int rst = threeSumClosest(nums, 12);
        System.out.println(rst);
    }
}
