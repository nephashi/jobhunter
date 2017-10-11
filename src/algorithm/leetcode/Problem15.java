package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -1 * nums[i];
            int k = i + 1, l = nums.length - 1;
            while (k < l) {
                if(nums[k] + nums[l] < target) {
                    k++;
                }
                else if(nums[k] + nums[l] > target) {
                    l--;
                }
                else if(nums[k] + nums[l] == target) {
                    results.add(Arrays.asList(nums[i], nums[k], nums[l]));
                    k++;
                    l--;
                    while (nums[k - 1] == nums[k] && k < l) k++;
                    while (nums[l + 1] == nums[l] && k < l) l--;
                }
            }
        }
        return results;
    }
}
