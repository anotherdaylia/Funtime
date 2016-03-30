package com.lia;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by liqu on 3/25/16.
 */
public class MoveZeros_283 {

    public void moveZeroes(int[] nums) {
        int zero = 0, non = 0;

        while (zero < nums.length && non < nums.length) {
            while (zero < nums.length && nums[zero] != 0) zero++;
            while (non < nums.length && nums[non] == 0 || non < zero) non++;

            if (zero == nums.length || non == nums.length) return;
            exch(nums, zero++, non++);
        }
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
