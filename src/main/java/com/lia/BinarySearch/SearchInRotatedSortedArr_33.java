package com.lia.BinarySearch;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Created by liqu on 6/7/16.
 */
public class SearchInRotatedSortedArr_33 {
    public int search(int[] nums, int target) {
        int rotatedMin = findMinIndex(nums);

        int a = Arrays.binarySearch(nums, 0, Math.max(rotatedMin - 1, 0) + 1, target);
        int b = Arrays.binarySearch(nums, rotatedMin, nums.length, target);

        if (a >= 0) return a;
        else if ( b >= 0) return b;
        else return -1;

    }

    public int findMinIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi && nums[lo] >= nums[hi]) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[lo] > nums[mid]){
                hi = mid;
            }
        }
        return lo;
    }
}
