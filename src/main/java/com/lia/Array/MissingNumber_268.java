package com.lia.Array;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 * Created by liqu on 4/26/16.
 */
public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int evenSum = (length / 2) * (length / 2 + 1);
        int oddSum;
        if (length % 2 != 0) {
            oddSum = (length / 2 + 1) * (length / 2 + 1);
        } else {
            oddSum = (length / 2 ) * (length / 2 );
        }

        int[] evenAndOdd = new int[2];
        evenAndOdd[0] = 0;
        evenAndOdd[1] = 0;
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) hasZero = true;
            if (nums[i] % 2 == 0) {
                evenAndOdd[0] += nums[i];
            } else {
                evenAndOdd[1] += nums[i];
            }
        }

        if (evenAndOdd[0] != evenSum) {
            return evenSum - evenAndOdd[0];
        } else if (evenAndOdd[1] != oddSum) {
            return oddSum - evenAndOdd[1];
        } else if (!hasZero) {
            return 0;
        } else return nums.length;
    }
}
