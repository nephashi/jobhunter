package algorithm.leetcode;


import java.util.*;

public class Problem207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> posts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] preCount = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> s = posts.get(i);
            for (int e : s) {
                preCount[e]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            while (j < numCourses) {
                if (preCount[j] == 0)
                    break;
                j++;
            }
            if (j == numCourses)
                return false;

            Set<Integer> s = posts.get(j);
            for (int e : s) {
                preCount[e]--;
            }
            preCount[j] = -1;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] pres = new int[][]{{1,0}};
        canFinish(2, pres);
    }

}
