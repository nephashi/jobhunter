package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {

    public static void subsetSearch(int[] nums, int curIdx, List<Integer> curList, int end, List<List<Integer>> rst) {
        if (curIdx == end)
            return;
        for (int i = curIdx; i < end; i++) {
            List<Integer> newList = new ArrayList<>(curList);
            newList.add(nums[i]);
            rst.add(newList);
            subsetSearch(nums, i + 1, newList, end, rst);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        rst.add(new ArrayList<>());
        List<Integer> init = new ArrayList<>();
        subsetSearch(nums, 0, init, nums.length, rst);
        return rst;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        subsets(array);
    }
}
