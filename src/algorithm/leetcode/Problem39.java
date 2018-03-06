package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem39 {

    private static void innerSearch(List<Integer> curPath, int[] candidates,
                                    int curCandidateIndex, int target, List<List<Integer>> rst) {
        int sum = 0;
        for (int i = 0; i < curPath.size(); i++) {
            sum += curPath.get(i);
        }
        if (sum == target) {
            rst.add(curPath);
            return;
        } if (sum > target) {
            curPath = null;
            return;
        }

        for (int i = curCandidateIndex; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(curPath);
            newList.add(candidates[i]);
            innerSearch(newList, candidates, i, target, rst);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        innerSearch(path, candidates, 0, target, rst);
        return rst;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[] {2, 3, 6, 7}, 7);
        System.out.println();
    }
}
