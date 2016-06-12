package com.lia.BinarySearch;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 * Created by liqu on 6/5/16.
 */
public class Search2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (target > matrix[m - 1][n - 1]) return false;

        int i;
        for (i = 0; i < m; i++) {
            if (matrix[i][n-1] >= target) {
                break;
            }
        }
        //System.out.println(Arrays.binarySearch(matrix[i], target));
        return (Arrays.binarySearch(matrix[i], target) >= 0) ? true : false;
    }
}
