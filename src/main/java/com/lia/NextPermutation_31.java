package com.lia;

/**
 * Created by liqu on 3/20/16.
 */

import java.util.Arrays;

public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        if (N == 0 || N == 1) return;

        //1. find the last in-order number pair (i, i+1) from the end of the array
        int i = N - 2;
        while (i >= 0){
            if (nums[i] < nums[i+1]) break;
            else i--;
        }

        // i < 0 or in order
        if (i < 0) {
            // lowest possible order (ie, sorted in ascending order)
            rotate(nums, 0, N-1);
        } else {
            //2. find the last number that are larger than the first number j
            int j = N - 1;
            while (j > i) {
                if (nums[j] > nums[i]) break;
                else j--;
            }

            //3. swap number i and j
            exch(nums, i, j);

            //4. rotate number after i
            rotate(nums, i+1, N-1);
        }
    }

    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void rotate(int[] nums, int lo, int hi) {
        while (lo < hi) {
            exch(nums, lo, hi);
            lo++;
            hi--;
        }
    }
}
