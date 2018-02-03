package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {

    static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = i;
            int second = i + 1;
            int last = nums.length - 1;
            while (second < last) {
                int sum = nums[second] + nums[last];
                if (sum < target - nums[first]) {
                    second++;
                } else if (sum > target - nums[first]) {
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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int[] tmpNums = Arrays.copyOfRange(nums, i + 1, nums.length);
            List<List<Integer>> tmp = threeSum(tmpNums, target - nums[i]);
            for (int j = 0; j < tmp.size(); j++) {
                tmp.get(j).add(nums[i]);
            }
            rst.addAll(tmp);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] s = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> rst = fourSum(s, 0);
        System.out.println();
    }
}
