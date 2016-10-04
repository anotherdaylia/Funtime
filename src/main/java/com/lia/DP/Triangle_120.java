package com.lia.DP;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle.

 * Created by liqu on 8/23/16.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int row = n - 2; row >= 0; row--) {
            List<Integer> curRow = triangle.get(row);
            List<Integer> nextRow = triangle.get(row + 1);
            for (int i = 0; i <= row; i++){
                curRow.set(i, curRow.get(i) + Math.min(nextRow.get(i), nextRow.get(i + 1)));
                //System.out.println(row + ", " + i + ", " + curRow.get(i));
            }
        }
        return triangle.get(0).get(0);
    }
}
