package com.lia.TwoPointer;

/**
 * Given a sorted array, remove the duplicates in place such that
 * each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * Created by liqu on 4/5/16.
 */
public class RemoveDupsFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int i = 1;
        int j = 0;

        while (j < nums.length - 1) {
            if (nums[j] == nums[j + 1]) {
                j++;
            }else{
                nums[i] = nums[j + 1];
                j++;
                i++;
            }
        }

        return i;

    }
}
