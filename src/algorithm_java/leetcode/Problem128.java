package algorithm.leetcode;

import java.util.HashSet;

public class Problem128 {
    public static int longestConsecutive(int[] nums) {
        int rst = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (set.remove(n)) {
                int prev = n - 1, next = n + 1;
                while (set.remove(prev)) prev--;
                while (set.remove(next)) next++;
                if (next - prev - 1 > rst)
                    rst = next - prev - 1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
