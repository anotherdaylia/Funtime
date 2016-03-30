package com.lia;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * Created by liqu on 3/25/16.
 */
public class FirstMissingPositive_41 {

    public int firstMissingPositive(int[] nums) {
        //if (nums == null || nums.length == 0) return 1;

        // keep moving nums[i] to index nums[i] - 1
        int next;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // filter out negatives, numbers larger than the length and number in the right place
            if (cur > 0 && cur <= nums.length && cur != i + 1) {
                do {
                    next = nums[cur - 1];
                    nums[cur - 1] = cur;
                    cur = next;
                    // stop when we find the 1st element in the right place
                } while (cur > 0 && cur <= nums.length && cur != nums[cur - 1]);
            }
        }

        // find the first missing number by comparing the number and the index
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != j + 1) break;
            j++;
        }

        return j+1;
    }
}
