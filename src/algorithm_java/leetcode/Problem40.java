package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    private static void innerSearch(List<Integer> curPath, int[] candidates,
                                    int curCandidatesIndex, int target, List<List<Integer>> rst) {
        int sum = 0;
        for (int i = 0; i < curPath.size(); i++) {
            sum += curPath.get(i);
        }
        if (sum == target) {
            rst.add(curPath);
            return;
        }
        if (sum > target) {
            curPath = null;
            return;
        }

        for (int i = curCandidatesIndex; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(curPath);
            newList.add(candidates[i]);
            innerSearch(newList, candidates, i + 1, target, rst);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        innerSearch(path, candidates, 0, target, rst);
        return rst;
    }

    public static void main(String[] args) {
        List<List<Integer>> rst = combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println();
    }
}
