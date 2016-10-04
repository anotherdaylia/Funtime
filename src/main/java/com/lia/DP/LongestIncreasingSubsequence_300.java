package com.lia.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101],
 * therefore the length is 4. Note that there may be more than one LIS combination,
 * it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * Created by liqu on 8/23/16.
 */
public class LongestIncreasingSubsequence_300 {
    // O(nlogn) Solution with Binary Search
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        List<Integer> seq = new ArrayList<>();
        for (int num : nums) {
            if (seq.isEmpty() || seq.get(seq.size() - 1) < num) seq.add(num);
            else {
                seq.set(findFirstLarge(seq, num), num);
            }
        }
        return seq.size();
    }

    private int findFirstLarge(List<Integer> seq, int key) {
        int lo = 0, hi = seq.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key <= seq.get(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
