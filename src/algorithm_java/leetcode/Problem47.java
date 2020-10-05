package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        innerSearch(nums, used, list, res);
        return res;
    }

    // 解此题的关键在于：给重复出现的元素限定插入顺序。即：相同元素在搜索树不断深入的过程中，只有之前的相同元素都插入了，当前元素才能插入。
    // 借由确保重复元素的唯一插入顺序，可以确保不会产生重复排列。
    // 具体表现即为判断前一个重复元素是否被使用，若未被使用则continue
    public static void innerSearch(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() >= nums.length) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            boolean[] new_used = Arrays.copyOf(used, used.length);
            List<Integer> new_cur = new ArrayList<>(cur);
            new_used[i] = true;
            new_cur.add(nums[i]);
            innerSearch(nums, new_used, new_cur, res);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lst = permuteUnique(new int[]{1,1,2});
    }
}