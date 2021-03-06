package com.lia.TwoPointer;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by liqu on 10/9/16.
 */
public class MoveZeros_283 {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int last = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                swap (nums, last, cur);
                last++;
            }
            cur++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
