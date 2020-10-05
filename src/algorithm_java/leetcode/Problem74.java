package algorithm.leetcode;

public class Problem74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int height = matrix.length;
        int width = matrix[0].length;
        int b = height - 1, t = 0, targetRow = -1;
        while (t <= b) {
            int m = (t + b) / 2;
            if (matrix[m][0] == target || matrix[m][width - 1] == target)
                return true;
            if (matrix[m][0] < target && matrix[m][width - 1] > target) {
                targetRow = m;
                break;
            } else if (target < matrix[m][0]) {
                b = m - 1;
            } else if (target > matrix[m][width - 1]) {
                t = m + 1;
            }
        }
        if (targetRow == -1)
            return false;
        else {
            int[] row = matrix[targetRow];
            int l = 0, r = width - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (row[m] == target) {
                    return true;
                } else if (target < row[m]) {
                    r = m - 1;
                } else if (target > row[m]) {
                    l = m + 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int a[][] = {{1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}};
        System.out.println(searchMatrix(a, 3));
    }

}
