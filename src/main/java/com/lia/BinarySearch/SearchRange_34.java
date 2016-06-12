package com.lia.BinarySearch;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * Created by liqu on 6/5/16.
 */
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                range[0] = searchStart(nums, target, lo, mid);
                range[1] = searchEnd(nums, target, mid, hi);
                break;
            }
        }
        return range;
    }

    private int searchStart(int[] nums, int target, int lo, int hi) {
        //System.out.println(lo +", " + hi);
        while (lo <= hi) {
            int mid = lo + (hi - lo ) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int searchEnd(int[] nums, int target, int lo, int hi) {
        //System.out.println(lo +", " + hi);
        while (lo <= hi) {
            int mid = lo + (hi - lo ) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid + 1] > target) return mid;
                else lo = mid + 1;
            }else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRangeIterative(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;

        // search for the start point
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[lo] != target) return range;
        else range[0] = lo;

        // search for the end point
        // We don't have to set i to 0 the second time.
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1; // Make mid biased to the right

            if (nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        range[1] = hi;

        return range;
    }
}
