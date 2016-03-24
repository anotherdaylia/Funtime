package com.lia;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].

 * Created by liqu on 3/21/16.
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public static List<Integer> spiralOrder (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res; // when the array is empty
        int n = matrix[0].length;

        int count = m * n; // keep track of remaining # of element
        int row = m, col = n; // keep track of remaining # of rows and cols
        boolean isHorizontal = true;
        int move = 1; // step to move forward

        // initial (x,y) position
        int x = 0, y = 0;
        while (count > 0) {
            if (isHorizontal) {
                // moving forward each step
                for (int i = 0; i < col; i++) {
                    res.add(matrix[x][y]);
                    y = y + move;
                }
                // re-adjust (x, y) position
                y = y - move;
                x = x + move;
                // update # of row and # of count
                row--;
                count = count - col;
                isHorizontal = !isHorizontal;
            } else {
                for (int j = 0; j < row; j++) {
                    res.add(matrix[x][y]);
                    x = x + move;
                }
                // re-adjust (x, y) position
                x = x - move;
                y = y - move;
                // update # of col and # of count
                col--;
                count = count - row;
                isHorizontal = !isHorizontal;
                // change move direction when complete adding vertical elements
                move = move * (-1);
            }
        }

        return res;
    }


    public static void main(String [ ] args) {
        int[][] matrix = new int[1][3];
        matrix[0] = new int[] {1,2,3};
//        matrix[1] = new int[] {4};
//        matrix[2] = new int[] {7};

        System.out.println(spiralOrder(matrix).toString());
    }
}
