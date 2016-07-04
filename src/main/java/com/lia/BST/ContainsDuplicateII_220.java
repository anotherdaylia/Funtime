package com.lia.BST;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t
 * and the difference between i and j is at most k.
 *
 * Created by liqu on 6/12/16.
 */
public class ContainsDuplicateII_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 1 || k < 0) return false;
        TreeSet<Long> set = new TreeSet<>();

        for (int j = 0; j < nums.length; j++) {
            // guarantee that all the index difference of numbers in the set are <= k
            if (j > k) set.remove((long)nums[j - k - 1]);

            long left = (long) nums[j] - t;
            long right = (long) nums[j] + t;

            // find subset where numbers difference is at most t.
            if (left <= right && !set.subSet(left, right + 1).isEmpty()) return true;

            set.add((long)nums[j]);
        }

        return false;
    }
}
