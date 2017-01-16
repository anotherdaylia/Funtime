package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 * Created by liqu on 6/21/16.
 */
public class Permutations_46 {

    /*
     Time Complexity: O(N!) N factorial
     Space Complexity: O(n) excluding result, O(n!) including result
      */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void permute(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int d) {
        if (d == nums.length) {
            ArrayList<Integer> perm = new ArrayList<>(list);
            result.add(perm);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            permute(result, list, nums, d+1);
            list.remove(list.size()-1);
        }
    }
}
