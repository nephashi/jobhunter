package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int depth = rows > cols ? (cols + 1) / 2 : (rows + 1) / 2;
        for (int i = 0; i < depth; i++) {
            int u = i;
            int b = rows - i - 1;
            int l = i;
            int r = cols - i - 1;
            for (int j = l; j <= r; j++) {
                ans.add(matrix[u][j]);
            }
            if (u != b) {
                for (int j = u + 1; j <= b; j++) {
                    ans.add(matrix[j][r]);
                }
                for (int j = r - 1; j >= l; j--) {
                    ans.add(matrix[b][j]);
                }
                if (l != r) {
                    for (int j = b - 1; j >= u + 1; j--) {
                        ans.add(matrix[j][l]);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        System.out.println();
    }
}
