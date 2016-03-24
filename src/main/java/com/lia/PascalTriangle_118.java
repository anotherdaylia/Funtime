package com.lia;

/**
 * Created by liqu on 3/19/16.
 */
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle_118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        if (numRows == 0) return pascal;

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        pascal.add(row1);

        for (int n = 1; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> pre = pascal.get(n-1);
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    row.add(pre.get(i));
                } else if ( 0 < i && i < n) {
                    row.add(pre.get(i - 1) + pre.get(i));
                } else {
                    row.add(pre.get (i-1));
                }
            }
            pascal.add(row);
        }
        return pascal;
    }

    // # 119
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) return row;

        List<Integer> pre = new ArrayList<>();
        for (int n = 1; n <= rowIndex; n++) {
            pre.clear();
            for (int in : row) pre.add(in);
            row.clear();
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    row.add(pre.get(i));
                } else if (i > 0 && i < n) {
                    row.add(pre.get(i - 1) + pre.get(i));
                } else {
                    row.add(pre.get(i - 1));
                }
            }
        }
        return row;
    }

    public static void main(String [ ] args) {
        List<List<Integer>> res = generate(5);
        for (int i : res.get(4)){
            System.out.println(i);
        }
    }
}
