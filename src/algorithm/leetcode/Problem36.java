package algorithm.leetcode;

public class Problem36 {

    private static boolean inColumn(char[][] board, char cur, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && cur == board[k][j])
                return true;
        }
        return false;
    }

    private static boolean inRow(char[][] board, char cur, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && cur == board[i][k])
                return true;
        }
        return false;
    }

    private static boolean inBox(char[][] board, char cur, int i, int j) {
        int boxStarti = i / 3 * 3, boxStartj = j / 3 * 3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (i != boxStarti + m && j != boxStartj + n &&
                        cur == board[boxStarti + m][boxStartj + n]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 7 && j == 6) {
                    System.out.println();
                }
                char cur = board[i][j];
                boolean inbox = inBox(board, cur, i, j);
                boolean incolumn = inColumn(board, cur, i, j);
                boolean inrow = inRow(board, cur, i, j);
                if (cur != '.') {
                    if (inBox(board, cur, i, j) || inColumn(board, cur, i, j) ||
                            inRow(board, cur, i, j)) {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] a = {{'.','.','.','.','.','.','.','.','2'},{'.','.','.','.','.','.','6','.','.'},{'.','.','1','4','.','.','8','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','3','.','.','.','.'},{'5','.','8','6','.','.','.','.','.'},{'.','9','.','.','.','.','4','.','.'},{'.','.','.','.','5','.','.','.','.'}};
        isValidSudoku(a);
    }
}
