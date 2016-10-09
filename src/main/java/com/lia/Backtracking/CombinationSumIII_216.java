package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Example 1:
 Input: k = 3, n = 7
 Output:[[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:[[1,2,6], [1,3,5], [2,3,4]]

 * Created by liqu on 6/21/16.
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        find(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }

    // To make sure unique combination, need to include search start point
    // so that it will never trace backward
    private void find(List<List<Integer>> result, List<Integer> list, int k, int n, int start) {
        for (int i: list) System.out.print(i + ",");
        //System.out.println(" sum =>" + sum );
        System.out.println("");

        if (k < 0 || k > n || (k == 0 && n != 0)) return;
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (list.contains(i)) continue;
            if (n - i >= 0) {
                list.add(i);
                find(result, list, k - 1, n - i, i+1);
                list.remove(list.size()-1);
            } else break;
        }
    }
}
