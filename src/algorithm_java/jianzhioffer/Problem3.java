package algorithm.jianzhioffer;

/**
 * 给定二维数组，每一行从左到右递增，从上到下递增。从这个数组中查找一个整数
 */
public class Problem3 {

    boolean search(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (col >= 0 && row < rows) {
            int tmp = matrix[row][col];
            if(tmp == target) return true;
            if(tmp > target) col--;
            if(tmp < target) row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Problem3 s = new Problem3();
        System.out.println(s.search(m, 12));
    }
}
