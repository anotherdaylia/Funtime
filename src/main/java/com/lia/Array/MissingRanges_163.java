package com.lia.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0,99] inclusive,
 * return its missing ranges.
 * For example,
 * given [0,1,3,50,75], return ["2", "4->49","51->74","76->99"]
 *
 *
 * Created by liqu on 8/30/16.
 */
public class MissingRanges_163 {
    /*
    Example questions candidate might ask:
    Q: What if the given array is empty?
    A: Then you should return ["0->99"] as those ranges are missing.
    Q: What if the given array contains all elements from the ranges?
    A: Return an empty list, which means no range is missing.

    Further thoughts:
    i. List out test cases.
    ii. You should be able to extend the above cases not only for range [0,99], but any arbitrary range [start, end]
     */
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for (int i = 0; i < vals.length; i++) {
            int cur = (i == vals.length) ? end + 1 : vals[i];
            if (cur - prev >= 2) {
                ranges.add(getRanges(prev + 1, cur - 1));
            }
            prev = cur;
        }
        return ranges;
    }

    private String getRanges(int from, int to) {
        return (from == to)? String.valueOf(from) : from + "->" + to;
    }

}
