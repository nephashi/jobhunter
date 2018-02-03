package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int last = nums.length - 1;
            while (second < last) {
                int sum = nums[second] + nums[last];
                if (sum < -1 * nums[first]) {
                    second++;
                } else if (sum > -1 * nums[first]) {
                    last--;
                } else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[first]);
                    lst.add(nums[second]);
                    lst.add(nums[last]);
                    result.add(lst);
                    while (second < nums.length - 1 && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    second++;
                    while (last > 0 && nums[last] == nums[last - 1]) {
                        last--;
                    }
                    last--;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tmp = {-1,0,1,2,-1,-4};
        List<List<Integer>> rst = threeSum(tmp);
        System.out.println();
    }
}
