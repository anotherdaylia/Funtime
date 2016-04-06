package com.lia.Array;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * Created by liqu on 3/16/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if(nums.length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length -2; j++) {
                // initialize the key
                int key = target - nums[i] - nums[j];
                // initialize pointer value
                int lo = j + 1, hi = nums.length - 1;

                while (lo < hi) {
                    if (nums[lo] + nums[hi] < key) lo++;
                    else if (nums[lo] + nums[hi] > key) hi--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        // change one of the value wouldn't make it equal again, hence change both
                        lo++;
                        hi--;
                        // avoid duplicate values
                        while (lo < hi && nums[lo - 1] == nums[lo]) lo++;
                        while (lo < hi && nums[hi + 1] == nums[hi]) hi--;
                    }
                }
                while (j < nums.length - 2 && nums[j + 1] == nums[j]) j++;
            }
            // avoid the duplicate result
            while (i < nums.length - 3 && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }

    public static void main(String [ ] args) {
        int[] nums = new int[] {1,0,-1,0,-2,2};
        List<List<Integer>> result = fourSum(nums, 0);

        for (List<Integer> list : result) {
            System.out.println("( " + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + "," + list.get(3) + ")");
        }

    }


}
