package com.lia.Array;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 *  Created by liqu on 3/25/16.
 */

import java.util.HashSet;

public class SetMatrixZeros_73 {

    public void setZeroesConstantSpace(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;

        boolean isFirstRowZeros = false;
        boolean isFirstColZeros = false;

        // check first col
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                isFirstColZeros = true;
                break;
            }
        }

        // check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0){
                isFirstRowZeros = true;
                break;
            }
        }

        // check all other elements
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // update first row
        if (isFirstRowZeros) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // update first col
        if (isFirstColZeros) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    if(!row.contains(i)) row.add(i);
                    if(!col.contains(j)) col.add(j);
                }
            }
        }

        for (int i : row) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : col) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }

    }
}
