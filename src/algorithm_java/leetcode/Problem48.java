package algorithm.leetcode;

public class Problem48 {

    public static void rotate(int[][] matrix) {
        int width = matrix.length;
        if (width == 1)
            return;
        int depth = (width + 1) / 2;
        for (int i = 0; i < depth; i++) {
            rotateCircle(matrix, i);
        }
    }

    public static void rotateCircle(int[][] matrix, int depth) {
        int u = depth;
        int b = matrix.length - depth - 1;
        if (u == b)
            return;
        int curWidth = matrix.length - depth * 2;
        for (int i = 0; i < curWidth - 1; i++) {
            int tmp = matrix[u][u + i];
            matrix[u][u + i] = matrix[b - i][u];
            matrix[b - i][u] = matrix[b][b - i];
            matrix[b][b - i] = matrix[u + i][b];
            matrix[u + i][b] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                if (j == matrix.length - 1)
                    System.out.print("\r\n");
                else
                    System.out.print(", ");
            }
        }
    }
}
