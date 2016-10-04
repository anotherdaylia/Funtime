package com.lia.DP;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 * Created by liqu on 9/24/16.
 */
public class MaximalSquare_221 {

    /*
    To know the area[i][j] you need to know the minimal among these three numbers:
    - area[i-1][j-1]
    - area[i][j-1]
    - area[i-1][j]

    area[i][j] = (Math.sqrt(min) + 1)^2

    But the better way is to save the length of edge instead of doing * every time
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (matrix == null || m == 0) return 0;

        int n = matrix[0].length;
        int[][] size = new int[m][n];
        int maxsize = 0;

        // initialization
        for (int i = 0; i < m; i++) {
            size[i][0] = matrix[i][0] - '0';
            maxsize = Math.max(maxsize, size[i][0]);
        }
        for (int j = 0; j < n; j++) {
            size[0][j] = matrix[0][j] - '0';
            maxsize = Math.max(maxsize, size[0][j]);
        }

        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    size[i][j] = Math.min(size[i-1][j-1], Math.min(size[i-1][j], size[i][j-1])) + 1;
                    maxsize = Math.max(maxsize, size[i][j]);
                }
            }
        }
        return maxsize * maxsize;
    }
}
