package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {

    private static boolean ifConflict(int[][] chessboard, int insertX, int insertY) {
        for (int y = insertY - 1, x = insertX - 1; y >= 0 && x >= 0; x--, y--) {
            if (chessboard[y][x] == 1)
                return true;
        }
        for (int y = insertY - 1, x = insertX + 1; y >= 0 && x < chessboard.length; x++, y--) {
            if (chessboard[y][x] == 1)
                return true;
        }
        return false;
    }

    private static void innerNQueenSearch(int[][] chessboard, int curRow, boolean[] usedCol, List<Integer[][]> rst) {
        int n = chessboard.length;
        if (curRow >= n) {
            Integer[][] tmp = new Integer[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp[i][j] = chessboard[i][j];
                }
            }
            rst.add(tmp);
        }
        for (int i = 0; i < n; i++) {
            if (usedCol[i] == false && !ifConflict(chessboard, i, curRow)) {
                boolean[] usedColCp = usedCol.clone();
                int[][] chessboardCp = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++)
                        chessboardCp[j][k] = chessboard[j][k];
                }
                usedColCp[i] = true;
                chessboardCp[curRow][i] = 1;
                innerNQueenSearch(chessboardCp, curRow + 1, usedColCp, rst);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<Integer[][]> rst = new ArrayList<>();
        int[][] initChessboard = new int[n][n];
        boolean[] initUsedCol = new boolean[n];
        innerNQueenSearch(initChessboard, 0, initUsedCol, rst);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < rst.size(); i++) {
            List<String> solution = new ArrayList<>();
            Integer[][] tmp = rst.get(i);
            for (int j = 0; j < tmp.length; j++) {
                StringBuffer sb = new StringBuffer();
                for (int k = 0; k < tmp.length; k++) {
                    if (tmp[j][k] == 1)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                solution.add(sb.toString());
            }
            ans.add(solution);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++)
                System.out.println(ans.get(i).get(j));
            System.out.println();
        }
    }

}
