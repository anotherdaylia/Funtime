package com.lia.BinarySearch;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 * Note:Your solution should be in logarithmic complexity.
 *
 * Created by liqu on 6/3/16.
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // middle case
            if (mid - 1 >= 0 && mid  + 1 < nums.length){
                if (nums[mid] > nums[mid - 1]) {
                    if (nums[mid] > nums[mid + 1]) {
                        return mid;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    hi = mid - 1;
                }
            }

            if (mid == 0) {
                if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return mid;
                // when mid == 0, lo have to be lo, and hi is either 0 or 1.
                // hi++ is bad because hi might be out of the array index bound and lo might no be greater than hi ever
                // lo++ could break the loop is mid + 1 >= length or shift mid to (mid + 1)
                else lo++;
            }
            if (mid == nums.length - 1) {
                if (mid - 1 >=0 && nums[mid] > nums[mid - 1]) return mid;
                else hi--;
            }
        }
        return lo;
    }

}
