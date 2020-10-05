package algorithm.leetcode;

public class Problem45 {
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = nums[0];
        int count = 1;
        int dist = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > dist) {
                count++;
                dist = max;
                if (dist >= nums.length)
                    return count;
            }
            max = Math.max(max, i + nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int step = jump(new int[]{3, 6, 6, 6, 3, 8, 9, 8, 5, 2, 9, 7, 3, 6, 5, 4,
                2, 3, 6, 9, 9, 8, 6, 4, 1, 0, 4, 4, 8, 9, 3, 6, 0, 7, 8, 1, 1, 8, 4});
        System.out.println(step);
    }
}
