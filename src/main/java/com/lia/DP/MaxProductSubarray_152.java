package com.lia.DP;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * Created by liqu on 9/23/16.
 */
public class MaxProductSubarray_152 {
    /*
    This problem is very similar to Question 53.
    Besides keeping track of the largest product, we also need to keep track of the
    smallest product - The smallest product, which is the largest in the negative sense
    could become the maximum when being multiplied by a negative number.
     */
    public int maxProduct(int[] nums) {
        int globalMax = nums[0], localMax = nums[0];
        int localMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = localMax, min = localMin;
            localMax = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            localMin = Math.min(min * nums[i], Math.min(max * nums[i], nums[i]));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
