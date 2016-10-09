package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 * Created by liqu on 6/21/16.
 */
public class Combination_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {
        // for (int i: list) System.out.print(i + ",");
        // System.out.println(" start= " + start );
        // System.out.println("");
        if (list.size() == k) {
            ArrayList<Integer> com = new ArrayList<>(list);
            result.add(com);
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combine(result, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}
