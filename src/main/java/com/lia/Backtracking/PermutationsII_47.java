package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]

 * Created by liqu on 6/21/16.
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permute(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void permute(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            ArrayList<Integer> perm = new ArrayList<>(list);
            result.add(perm);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            list.add(nums[i]);
            used[i] = true;
            permute(result, list, nums, used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
