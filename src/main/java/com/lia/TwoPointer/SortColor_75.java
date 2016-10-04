package com.lia.TwoPointer;

/**
 * Given an array with n objects colored red, white or blue,
 * Sort them so that objects of the same color are adjacent,
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

    // Counting Sort method
    public void sortColorsCount(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) red++;
            else if(nums[i] == 1) white++;
            else blue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > 0){
                nums[i] = 0;
                red--;
                continue;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
                continue;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
                continue;
            }
        }
    }
}
