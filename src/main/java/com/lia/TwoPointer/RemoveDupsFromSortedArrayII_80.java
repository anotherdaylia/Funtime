package com.lia.TwoPointer;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 *
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the First five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * Created by liqu on 4/5/16.
 */
public class RemoveDupsFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 0;
        int count = 1;
        for(int j = 1; j < nums.length; j++) {

            if (nums[i] == nums[j]) {
                if (count == 1) {
                    i++;
                    nums[i] = nums[j];
                }
                count++;
            } else {
                i++;
                nums[i] = nums[j];
                count = 1;
            }
        }
        return i + 1;
    }
}
