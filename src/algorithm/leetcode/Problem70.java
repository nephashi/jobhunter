package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem70 {

    public static void climbStairsSearch(int curStair, List<Integer> curClimb,
                                         int n, List<List<Integer>> rst) {
        if (curStair == n) {
            rst.add(curClimb);
        } else if (curStair < n) {
            List<Integer> step1Climb = new ArrayList<>(curClimb);
            step1Climb.add(1);
            climbStairsSearch(curStair + 1, step1Climb, n, rst);

            List<Integer> step2Climb = new ArrayList<>(curClimb);
            step2Climb.add(2);
            climbStairsSearch(curStair + 2, step2Climb, n, rst);
        }
    }

    // this takes too much time
    public static int climbStairs1(int n) {
        List<List<Integer>> search = new ArrayList<>();
        climbStairsSearch(0, new ArrayList<>(), n, search);
        return search.size();
    }

    public static int climbStairs(int n) {
        if(n <= 2) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; i++){
            arr[i]=arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(35));
    }

}
