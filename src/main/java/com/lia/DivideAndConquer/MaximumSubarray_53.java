package com.lia.DivideAndConquer;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 https://leetcode.com/discuss/15805/accepted-o-n-solution-in-java

 * Created by liqu on 6/30/16.
 */
public class MaximumSubarray_53 {
    /*
    Algorithm that operates on arrays: it starts at the left end (A[1]) and scans through to the right end (A[n]),
    keeping track of the maximum sum subvector seen so far. The maximum is initially A[0].

    Suppose we've solved the problem for A[1...i-1], how can we extend that to A[1...i]?
    - The maximum sum in the first i elements is either the maximum sum in the first i-1 element (maxSoFar),
    or it is that of a subvector that ends in position i (maxToEnd).
    - maxToEnd is either A[i] plus the previous MaxToEnd, or just A[i], whichever is larger.
     */
    public int MaxSubarray(int[] nums) {
        int maxSoFar = nums[0],  maxToEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToEnd = Math.max(maxToEnd + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxToEnd);
        }
        return maxSoFar;
    }
}
