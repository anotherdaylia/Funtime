package com.lia.Array;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * Created by liqu on 3/15/16.
 */

import java.util.HashMap;

public class ContainDupII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if ( (i - map.get(nums[i])) > k ) {
                    map.put(nums[i], i);
                } else {
                    return true;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // Solution 2: HashMap
    public boolean containsNearbyDuplicateHM(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <number, index>

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);
                if (diff <= k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
