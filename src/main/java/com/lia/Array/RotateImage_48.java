package com.lia.Array;

import org.junit.Test;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 * Created by liqu on 3/13/16.
 */
public class RotateImage_48 {

    @Test
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        int[][] copy = new int[N][];
        for (int i = 0; i < N; i++) {
            copy[i] = matrix[i].clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[j][N-i-1] = copy[i][j];
            }
        }

    }

    public void rotateInPlace(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;

        for (int i = 0; i < n/2; i++) {
            int[] row = matrix[i].clone();
            for (int j = i; j < n - i - 1; j++) {
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = row[j];
            }
        }
    }

    public static void main(String [ ] args) {
        RotateImage_48 ri = new RotateImage_48();
        int[][] matrix = {{1, 2}, {3, 4}};
    }

    /*
    1/2017
     */
    public void rotateII(int[][] matrix) {
        int n = matrix.length;

        // mirror upside down
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                swap(matrix, i, j, n - i - 1, j);
            }
        }

        // transpose with diagnal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    swap(matrix, i, j, j, i);
                }
            }
        }

    }

    private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int tmp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = tmp;
    }
}
