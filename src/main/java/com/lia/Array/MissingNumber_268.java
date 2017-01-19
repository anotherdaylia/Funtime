package com.lia.Array;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implementit using only constant extra space complexity?
 * Created by liqu on 4/26/16.
 */
public class MissingNumber_268 {

    /*
    Binary search solution
    Time complexity: O(logN)

    created by liqu on 1/18/2017
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // determine the range of search
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
