package com.lia.Unfinished;

import com.lia.Sort.Interval;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 * Created by liqu on 6/16/16.
 */
public class MergeIntervals_56 {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();




        return result;
    }

    private int findPosition(List<Interval> intervals, int p) {
        int lo = 0, hi = intervals.size() - 1;

        if (p < intervals.get(0).start) return 0;
        if (p > intervals.get(intervals.size() - 1).end) return -intervals.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int start = intervals.get(mid).start;

            if (p < start) {
                if (mid > lo && intervals.get(mid - 1).end < p) return -mid;
                else hi = mid - 1;
            } else if (p > start) {
                if (p <= intervals.get(mid).end) return mid;
                else if (mid < hi && p < intervals.get(mid + 1).start) return -(mid + 1);
                else lo = mid + 1;
            } else return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        MergeIntervals_56 mi = new MergeIntervals_56();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(4,6));
        intervals.add(new Interval(9,10));

        int p = mi.findPosition(intervals, 12);
        System.out.println(p);
    }

}
