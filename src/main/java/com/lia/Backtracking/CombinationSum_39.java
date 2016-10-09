package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 * Created by liqu on 6/21/16.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            sum += candidates[i];
            if (sum <= target) {
                list.add(candidates[i]);
                findSum(result, list, candidates, sum, target, i);
                sum -= candidates[i];
                list.remove(list.size()-1);
            } else break;
        }
    }
}
