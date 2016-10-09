package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 * Created by liqu on 6/21/16.
 */
public class SubsetsIi_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        ArrayList<Integer> subset = new ArrayList<>(list);
        result.add(subset);

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i-1] == nums[i]) continue;
            list.add(nums[i]);
            subsets(result, list, nums, i + 1);
            list.remove(list.size()-1);
        }
    }

}
