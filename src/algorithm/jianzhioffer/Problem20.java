package algorithm.jianzhioffer;

public class Problem20 {

    public static void printMatrixClockwisely(int[][] matrix, int columns, int rows) {
        int count = (int)Math.ceil(Math.min(columns, rows) / 2.0);
        for(int i = 0; i < count; i++) {
            printMatrixCore(matrix, columns - 1, rows - 1, i);
        }
    }

    public static void printMatrixCore(int[][] matrix, int columns, int rows, int circle) {
        int rStart, rEnd, cStart, cEnd;
        rStart = cStart = circle;
        rEnd = rows - circle;
        cEnd = columns - circle;
        for(int i = cStart; i <= cEnd; i++)
            System.out.print(matrix[rStart][i]);
        if(rStart!=rEnd) {
            for(int i = rStart + 1; i <= rEnd; i++) {
                System.out.print(matrix[i][cEnd]);
            }
        }
        if(cStart != cEnd && rStart != rEnd) {
            for(int i = cEnd - 1; i >= cStart; i--) {
                System.out.print(matrix[rEnd][i]);
            }
        }
        if(cStart != cEnd && rEnd > rStart + 1) {
            for(int i = rEnd - 1; i >= rStart + 1; i--)
               System.out.print(matrix[i][cStart]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixClockwisely(matrix,4,3);
    }
}
