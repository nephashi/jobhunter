package algorithm.leetcode;

public class Problem200 {

    public static boolean[][] used;

    public static void searchIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '0')
            return;
        else if (grid[i][j] == '1') {
            used[i][j] = true;
            if (i - 1 >= 0 && !used[i - 1][j])
                searchIsland(grid, i - 1, j);
            if (j - 1 >= 0 && !used[i][j - 1])
                searchIsland(grid, i, j - 1);
            if (i + 1 < grid.length && !used[i + 1][j])
                searchIsland(grid, i + 1, j);
            if (j + 1 < grid[0].length && !used[i][j + 1])
                searchIsland(grid, i, j + 1);
        }
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    searchIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
