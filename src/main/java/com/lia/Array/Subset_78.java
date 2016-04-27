package com.lia.Array;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
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
 * Created by liqu on 4/26/16.
 */
public class Subset_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());

        int k = 0;
        while ( k < nums.length ) {
            List<List<Integer>> buffer = new ArrayList<>();
            for(List<Integer> list : subsets) {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(nums[k]);
                // making sure that elements in a subset is in non-descending order
                Collections.sort(newList);
                buffer.add(newList);
            }
            subsets.addAll(buffer);
            k++;
        }
        return subsets;
    }
}
