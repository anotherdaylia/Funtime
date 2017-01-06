package com.lia.DFS_BFS;

/**
 * Created by liqu on 1/1/17.
 */
public class NumOfIslands_200 {

    // My original solution
    public int numIslands(char[][] grid) {
        if (grid.length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] explored = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (explored[i][j]) continue;
                if (grid[i][j] == '1') {
                    count++;
                    explore(grid, i, j, explored);
                }
            }
        }
        return count;
    }

    private void explore(char[][] grid, int i, int j, boolean[][] explored) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || explored[i][j] || grid[i][j] != '1') return;
        explored[i][j] = true;
        explore(grid, i - 1, j, explored);
        explore(grid, i + 1, j, explored);
        explore(grid, i, j - 1, explored);
        explore(grid, i, j + 1, explored);
    }



    /* Other's solution - faster
    But if it's not allowed to modify the original input, then a boolean[][] explored need to be introduced.
     */
    private int n, m;

    public int numIslandsII(char[][] grid) {
        n = grid.length;
        if (n < 1) return 0;
        m = grid[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    markZero(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void markZero(char[][] grid, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        markZero(grid, i - 1, j);
        markZero(grid, i + 1, j);
        markZero(grid, i, j - 1);
        markZero(grid, i, j + 1);
    }
}
