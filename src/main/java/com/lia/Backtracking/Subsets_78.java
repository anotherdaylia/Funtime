package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 * Created by liqu on 6/21/16.
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        ArrayList<Integer> subset = new ArrayList<>(list);
        result.add(subset);

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(result, list, nums, i + 1);
            list.remove(list.size()-1);
        }
    }
}
