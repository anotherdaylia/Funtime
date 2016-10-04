package com.lia.DP;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Created by liqu on 8/23/16.
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1) return 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) { continue;}
                if (i - 1 < 0) grid[i][j] += grid[i][j - 1];
                else if (j - 1 < 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m-1][n-1];
    }
}
