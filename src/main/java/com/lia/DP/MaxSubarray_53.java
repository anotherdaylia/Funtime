package com.lia.DP;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * Created by liqu on 9/23/16.
 */
public class MaxSubarray_53 {
    // https://leetcode.com/discuss/15805/accepted-o-n-solution-in-java
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxToEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToEnd = Math.max(maxToEnd + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxToEnd);
        }
        return maxSoFar;
    }
}
