package com.lia.BinarySearch;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 * Created by liqu on 6/7/16.
 */
public class FindTheDupNumber_287 {

    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int lo = 1, hi = n; // value not index

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // value not index
            int leftcounter = 0, rightcounter = 0, midcounter = 0;

            for (int i = 0; i <= n; i++) {
                if (nums[i] >= lo && nums[i] < mid) leftcounter++;
                else if (nums[i] > mid && nums[i] <= hi) rightcounter++;
                else if (nums[i] == mid) midcounter++;
            }
            //System.out.println(mid);
            if (midcounter > 1) return mid;

            if (leftcounter >= rightcounter ) hi = mid - 1;
            else lo = mid + 1;
        }

        return -1;
    }
}
