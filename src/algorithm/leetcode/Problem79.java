package algorithm.leetcode;

public class Problem79 {

    public static boolean existSearch(char[][] board, int curX, int curY,
                                      boolean[][] visited, StringBuilder curSb,
                                      int curIdx, String target) {
        if (curSb.length() == target.length())
            return true;
        if (curX >= board[0].length || curY >= board.length || curX < 0 || curY < 0) {
            return false;
        }
        if (visited[curY][curX] == true)
            return false;
        if (board[curY][curX] == target.charAt(curIdx)) {
            StringBuilder newSb = new StringBuilder(curSb);
            newSb.append(board[curY][curX]);
            visited[curY][curX] = true;
            boolean rst =  existSearch(board, curX + 1, curY, visited, newSb, curIdx + 1, target) ||
                    existSearch(board, curX - 1, curY, visited, newSb, curIdx + 1, target) ||
                    existSearch(board, curX, curY + 1, visited, newSb, curIdx + 1, target) ||
                    existSearch(board, curX, curY - 1, visited, newSb, curIdx + 1, target);
            visited[curY][curX] = false;
            return rst;
        } else {
            return false;
        }

    }

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                StringBuilder sb = new StringBuilder();
                if (existSearch(board, j, i, visited, sb, 0, word))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCESEEEFS"));
//        char[][] board = new char[][]{
//                {'a', 'a'}
//        };
//
//        System.out.println(exist(board, "aaa"));
    }
}
