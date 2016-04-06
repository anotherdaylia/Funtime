package com.lia.Array;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 * Created by liqu on 3/22/16.
 */
public class SpiralMatrix_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int rowlo = 0, collo = 0;
        int rowhi = n - 1, colhi = n - 1;
        boolean isHorizontal = true;
        boolean isForward = true;

        int c = 1;
        while (c <= n*n) {

            if (isHorizontal && isForward) {
                for (int y = collo; y <= colhi; y++) {
                    matrix[rowlo][y] = c;
                    c++;
                }
                rowlo++;
                isHorizontal = !isHorizontal;
            } else if (!isHorizontal && isForward){
                for (int x = rowlo; x <= rowhi; x++) {
                    matrix[x][colhi] = c;
                    c++;
                }
                colhi--;
                isHorizontal = !isHorizontal;
                isForward = !isForward;
            } else if (isHorizontal && !isForward) {
                for (int y = colhi; y >= collo; y--) {
                    matrix[rowhi][y] = c;
                    c++;
                }
                rowhi--;
                isHorizontal = !isHorizontal;
            } else {
                for (int x = rowhi; x >= rowlo; x--) {
                    matrix[x][collo] = c;
                    c++;
                }
                collo++;
                isHorizontal = !isHorizontal;
                isForward = !isForward;
            }
        }
        return matrix;
    }
}
