package com.lia.Array;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * Created by liqu on 3/15/16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum_15 {

    public static List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // two sum with two pointer
            // the key is following the value of index i
            int key = -nums[i];
            // initialize pointer value
            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                if (nums[lo] + nums[hi] < key) {
                    lo++;
                } else if (nums[lo] + nums[hi] > key){
                    hi--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    // change one of the value wouldn't make it equal again, hence change both
                    lo++;
                    hi--;
                    // avoid duplicate values
                    while (lo < hi && nums[lo - 1] == nums[lo]) lo++;
                    while (lo < hi && nums[hi + 1] == nums[hi]) hi--;
                }
            }

            // avoid the duplicate result
            while (i < nums.length - 2 && nums[i+1] == nums[i]) i++;
        }

        return result;
    }

    public static void main(String [ ] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4, 8};
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> list : result) {
            System.out.println("( " + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + ")");
        }

    }
}
