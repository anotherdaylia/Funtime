package com.lia.BinarySearch;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Created by liqu on 6/3/16.
 */
public class FindMinInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi && nums[lo] >= nums[hi]) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[lo] > nums[mid]){
                hi = mid;
            }
        }
        return nums[lo];
    }

}
