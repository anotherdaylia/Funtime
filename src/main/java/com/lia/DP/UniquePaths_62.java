package com.lia.DP;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * Created by liqu on 8/23/16.
 */
public class UniquePaths_62 {
    public int uniquePaths(int m, int n) {
        int[][] cell = new int[m+1][n+1];
        cell[0][1] = 1; //helper

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //System.out.println(cell[i-1][j] + ", " + cell[i][j-1]);
                cell[i][j] += cell[i-1][j];
                cell[i][j] += cell[i][j-1];
            }
        }
        return cell[m][n];
    }
}
