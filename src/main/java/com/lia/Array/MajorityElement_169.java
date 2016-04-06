package com.lia.Array;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Created by liqu on 3/17/16.
 */

import java.util.Arrays;

public class MajorityElement_169 {
    static int element = -1;

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) { return nums[0];}

        int i = 1;
        int count = 1;
        while(i < nums.length) {
            if (count < nums.length/2) {
                if (nums[i- 1] == nums[i]) count++;
                else count = 1;
                i++;
            } else {
                element = nums[i];
                break;
            }
        }

        if ( i >= nums.length && count >= nums.length/2) {
            element = nums[nums.length - 1];
        }
        return element;
    }
}
