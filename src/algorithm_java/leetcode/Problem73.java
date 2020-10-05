package algorithm.leetcode;

public class Problem73 {

    public static void setZeroes(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        boolean colZFlag = false, rowZFlag = false;
        for (int i = 0; i < width; i++)
            if (matrix[0][i] == 0) {
                rowZFlag = true;
                break;
            }
        for (int i = 0; i < height; i++) {
            if (matrix[i][0] == 0) {
                colZFlag = true;
                break;
            }
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < width; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < height; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZFlag) {
            for (int i = 0; i < width; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZFlag) {
            for (int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,1,1},{1,0,1},{1,1,1}
        };
        setZeroes(matrix);
        System.out.println();
    }

}
