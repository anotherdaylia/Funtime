package com.lia.TwoPointer;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Created by liqu on 4/5/16.
 */
public class SortColor_75 {
    public void sortColors(int[] nums) {
        int r = 0, b = nums.length - 1;
        int w = r;

        while (w <= b) {

            if (nums[w] == 0) {
                swap(nums, r, w);
                r++;
                w++;
            } else if (nums[w] == 1) {
                w++;
            } else if (nums[w] == 2) {
                swap(nums, w, b);
                b--;
            }
        }
    }


    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
