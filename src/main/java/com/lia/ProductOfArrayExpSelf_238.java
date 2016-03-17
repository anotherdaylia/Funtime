package com.lia;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that
 * output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * Created by liqu on 3/13/16.
 */
public class ProductOfArrayExpSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        // Extra space = 3N;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] output = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }

        // output equals the product of left elements multiply the product of right elements
        for (int i = 0; i < nums.length; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}


