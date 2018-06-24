package algorithm.leetcode;

public class Problem59 {

    private static int generateCircle(int[][] matrix, int depth, int start) {
        int u = depth;
        int b = matrix.length - 1 - depth;
        for (int i = u; i <=b; i++) {
            matrix[u][i] = start;
            start++;
        }
        if (b > u) {
            for (int i = u + 1; i <= b; i++) {
                matrix[i][b] = start;
                start++;
            }
            for (int i = b - 1; i >= u; i--) {
                matrix[b][i] = start;
                start++;
            }
            if (b > u + 1) {
                for (int i = b - 1; i >= u + 1; i--) {
                    matrix[i][u] = start;
                    start++;
                }
            }
        }
        return start;
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int depth = (n + 1)/ 2;
        int start = 1;
        for (int i = 0; i < depth; i++) {
            start = generateCircle(matrix, i, start);
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        System.out.println();
    }

}
