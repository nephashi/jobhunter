package algorithm.leetcode;

public class Problem62 {

    public static int uniquePaths(int m, int n) {
        int width = m - 1;
        int depth = n - 1;
        int sum = width + depth;

        int small = width < depth ? width : depth;

        long ans = 1;

        for (int i = 0; i < small; i++) {
            ans *= (sum - i);
        }
        for (int i = 1; i <= small; i++) {
            ans /= i;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 10));
    }

}
