public class Test {

    private static void change(int[][] matrix) {
        matrix[1][1] = 100;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        change(matrix);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
}
