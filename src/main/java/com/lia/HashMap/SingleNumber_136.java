package com.lia.HashMap;

import java.util.HashMap;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * Created by liqu on 4/24/16.
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],1);
            }
        }

        int one = 0;
        for(int i : map.keySet()){
            one = i;
        }

        return one;
    }

    public int singleNumberBit(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
