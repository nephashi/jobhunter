package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    private static void inner_permute(int[] nums, int cur_idx, List<Integer> cur, List<List<Integer>> rst) {
        if (cur_idx >= nums.length) {
            rst.add(cur);
            return;
        }
        for (int i = 0; i <= cur.size(); i++) {
            List<Integer> new_lst = new ArrayList<>(cur);
            new_lst.add(i, nums[cur_idx]);

            inner_permute(nums, cur_idx + 1, new_lst, rst);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        inner_permute(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = permute(new int[]{1,2,3});
        System.out.println();
    }
}
