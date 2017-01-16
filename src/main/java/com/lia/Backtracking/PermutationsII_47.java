package com.lia.Backtracking;

import java.util.*;

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
    /*
    It's looking for permutation - the input's order does not matter.
    The idea is not use the same number again at the same level -
        . skip nums[i] if nums[i] == nums[i-1]
        . to determine if they at at the sam level, nums[i - 1] is not visited.
        . visited[] == true is used in the next levels.
     */
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


    /*
    My solution use Set to store the used element at each level.
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUniqueMine(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        generate(nums, visited, new ArrayList<>(), 0);
        return res;
    }

    private void generate(int[] nums, boolean[] visited, List<Integer> perm, int k) {
        // base case
        if (k == nums.length) res.add(new ArrayList<>(perm));

        Set<Integer> set = new HashSet<>(); // element visited at this level
        // rec case
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (set.contains(nums[i])) continue;
                else set.add(nums[i]);

                visited[i] = true;
                perm.add(nums[i]);
                generate(nums, visited, perm, k + 1);
                visited[i] = false;
                perm.remove(perm.size() - 1);
            }
        }

    }
}
