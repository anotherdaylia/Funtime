package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 * Created by liqu on 6/21/16.
 */
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(result, new ArrayList<>(), candidates, 0, target, 0);
        return result;
    }

    private void findSum(List<List<Integer>> result, List<Integer> list, int[] candidates, int sum, int target, int start) {
        // for (int i: list) System.out.print(i + ",");
        // System.out.println(" sum =>" + sum );
        // System.out.println("");

        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // This line skips the dup combination from the dup element in candidates
            if (i > start && candidates[i] == candidates[i-1]) continue;
            sum += candidates[i];
            if (sum <= target) {
                list.add(candidates[i]);
                findSum(result, list, candidates, sum, target, i+1);
                sum -= candidates[i];
                list.remove(list.size()-1);
            } else break;
        }
    }
}
