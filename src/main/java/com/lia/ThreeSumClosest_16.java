package com.lia;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Created by liqu on 3/16/16.
 */

public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int key = target - nums[i];
            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                int two = nums[lo] + nums[hi];
                if (two < key) {
                    int three = nums[i] + nums[lo] + nums[hi];
                    if (Math.abs(target - result) > Math.abs(target - three)){
                        result = three;
                    }
                    lo++;
                } else if (two > key) {
                    int three = nums[i] + nums[lo] + nums[hi];
                    if (Math.abs(target - result) > Math.abs(target - three)){
                        result = three;
                    }
                    hi--;
                } else {
                    return target;
                }
            }
            while (i < nums.length - 2 && nums[i+1] == nums[i]) i++;
        }
        return result;
    }
}
