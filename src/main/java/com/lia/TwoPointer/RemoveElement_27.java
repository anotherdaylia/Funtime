package com.lia.TwoPointer;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Created by liqu on 4/7/16.
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) return 0;

        int i = 0;
        int j = nums.length - 1;

        // This method referred to the partition() method of Quicksort
        while(true) {
            while (nums[i] != val) {
                i++;
                if(i == nums.length) break;
            }

            while (nums[j] == val) {
                j--;
                if(j == -1) break;
            }

            if(i >= j) break;
            exch(nums, i, j);
        }

        return i;
    }

    private void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
