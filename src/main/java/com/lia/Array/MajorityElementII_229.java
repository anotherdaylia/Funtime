package com.lia.Array;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 *
 * Created by liqu on 3/17/16.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElementII_229 {

    // Sorting method
    public List<Integer> majorityElementSort(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        if (nums.length <= 2) {
            for (int i : nums) {
                if (!result.contains(nums[i])) result.add(nums[i]);
            }
            return result;
        }

        Arrays.sort(nums);
        int i = 1, count = 1;
        while (i < nums.length) {
            if (nums[i-1] == nums[i]) count++;
            else count = 1;

            if (count > nums.length/3 && !result.contains(nums[i])){
                result.add(nums[i]);
            }
            i++;
        }
        return result;
    }

    public static List<Integer> majorityElement (int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;

        // Moore's Voting Algorithm
        // two candidates with top 2 frequency
        int num1 = nums[0], num2 = nums[0];
        int count1 = 0, count2 = 0;

        for (int i : nums) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
            // Once count equals 0, then switch the candidate to the current number.
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            // If meeting different number from the candidate, then decrease 1 from its count
            } else {
                count1--;
                count2--;
            }
        }

        // We need to count again for the two candidates after the First loop
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
        }
        if (count1 > nums.length / 3) result.add(num1);
        if (count2 > nums.length / 3) result.add(num2);

        return result;
    }

    public static void main(String [ ] args) {
        int[] nums = new int[] {2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
        List<Integer> me = majorityElement(nums);

        for (Integer i : me) {
            System.out.println(i);
        }

    }
}
