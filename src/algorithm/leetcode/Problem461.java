package algorithm.leetcode;

public class Problem461 {

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            count++;
            z = (z - 1) & z;
        }
        return count;
    }


}
