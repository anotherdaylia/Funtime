package com.lia.DFS_BFS;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 * Created by liqu on 6/29/16.
 */
public class LongestIncreasingPathInMatrix_329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int max = 0, n = matrix.length, m = matrix[0].length;

        int[][] cache = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                max = Math.max(max, path(matrix, i, j, Integer.MIN_VALUE, cache));
            }
        }
        return max;
    }

    private int path(int[][] matrix, int row, int col, int pre, int[][] cache) {
        // check boundary limits
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length) return 0;

        // check increasing condition
        int cur = matrix[row][col];
        if (cur <= pre) return 0;

        // check cache
        /*
        two use:
        1. keep the max number of increasing number to this cell
        2. skip this cell is it's visited/calculated
        */
        if (cache[row][col] != 0) return cache[row][col];

        int a = path(matrix, row - 1, col, cur, cache) + 1;
        int b = path(matrix, row + 1, col, cur, cache) + 1;
        int c = path(matrix, row, col - 1, cur, cache) + 1;
        int d = path(matrix, row, col + 1, cur, cache) + 1;

        int max = Math.max(a, Math.max(b, Math.max(c,d)));
        cache[row][col] = max;

        return max;
    }
}
