package com.lia.Array;

/**
 * Created by liqu on 3/19/16.
 */
public class SearchInsertPosition_35 {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) lo = mid + 1;
            else if (target < nums[mid]) hi = mid - 1;
            else return mid;
        }

        return lo;
    }

    public static int searchInsert2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static void main(String [] args ){
        int[] nums = new int[] {1, 3};
        int res = searchInsert2(nums, 4);
        System.out.println(res);
    }
}
