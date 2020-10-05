package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem406 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return 1;
                else if (o1[0] > o2[0])
                    return -1;
                else if (o1[1] < o2[1])
                    return -1;
                else if (o1[1] > o2[1])
                    return 1;
                return 0;
            }
        });
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            tmp.add(people[i][1], people[i]);
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            ans[i][0] = tmp.get(i)[0];
            ans[i][1] = tmp.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] people = new int[][] {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        reconstructQueue(people);
    }

}
