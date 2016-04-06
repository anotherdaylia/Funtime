package com.lia.Array;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * Created by liqu on 3/20/16.
 */
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null) throw new java.util.NoSuchElementException();
        int N = nums.length;
        List<String> res = new ArrayList<>();
        if (N == 0) return res;
        if (N == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }

        int lo = 0, hi = 0;
        while(hi < N - 1) {
            if (nums[hi] + 1 == nums[hi + 1]) hi++;
            else {
                if (nums[lo] == nums[hi]) res.add(Integer.toString(nums[lo]));
                else {
                    String range = Integer.toString(nums[lo]) + "->" + Integer.toString(nums[hi]);
                    res.add(range);
                }
                hi++;
                lo = hi;
            }
        }

        // hi = N - 1 (last element)
        if (nums[hi - 1] + 1 == nums[hi]) {
            String range = Integer.toString(nums[lo]) + "->" + Integer.toString(nums[hi]);
            res.add(range);
        } else {
            if (nums[lo] == nums[hi]) res.add(Integer.toString(nums[lo]));
            else {
                String range = Integer.toString(nums[lo]) + "->" + Integer.toString(nums[hi-1]);
                res.add(range);
                res.add(Integer.toString(nums[hi]));
            }
        }

        return res;
    }
}
