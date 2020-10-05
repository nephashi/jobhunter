package algorithm.leetcode;

import java.util.Arrays;

public class Problem621 {

    public static int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (int i = 0; i < tasks.length; i++)
            cnt[tasks[i] - 'A'] += 1;
        Arrays.sort(cnt);
        int i = 25, max = cnt[25], len = tasks.length;
        while (i >= 0 && cnt[i] == max)
            i--;
        return Math.max(len, (max - 1) * (n + 1) + 25 - i);
    }

}
