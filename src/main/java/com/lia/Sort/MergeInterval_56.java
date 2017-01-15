package com.lia.Sort;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Created by liqu on 1/15/17.
 */
public class MergeInterval_56 {

    /*
    Sort the intervals by their starting point.
     */
    private final Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        @Override
        public int compare(Interval in1, Interval in2) {
            return in1.start - in2.start;
        }
    };

    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        if (n <= 1) return intervals;
        Collections.sort(intervals, intervalComparator);

        int i = 0;
        while (i < n - 1) {
            boolean merged = mergeTwoIntervals(intervals, i, i + 1);
            if (merged) n--;
            else i++;
        }
        return intervals;
    }

    private boolean mergeTwoIntervals(List<Interval> intervals, int i, int j) {
        Interval intval1 = intervals.get(i);
        Interval intval2 = intervals.get(j);

        if (intval1.end >= intval2.start) {
            intval1.end = intval1.end > intval2.end ? intval1.end : intval2.end;
            intervals.remove(j);
            return true;
        } else return false;
    }

    /*
    Use anonymous comparator with lambda to sort intervals by the start point.

    Compare current intervals end with next intervals start.
    If overlap, merge two intervals, and assign cur's end with the max end valud of (cur, next)
    If not overlap, add current interval to result.

    DONNOT forget the last interval pointed by cur, which needed to be add to result.

    Time complexity: sort is O(nlogn), looping is O(n), total is O(nlogn).
    Space: O(1).

    created by liqu on 1/15/2017
     */
    public List<Interval> mergeII(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int n = intervals.size();
        if (n <= 1) return intervals;

        Collections.sort(intervals,
                (interval1, interval2) -> (interval1.start - interval2.start));

        Interval cur = intervals.get(0);
        for (int i = 1; i < n; i++) {
            Interval next = intervals.get(i);
            if (next.start <= cur.end) { // overlaps and merge
                cur.end = Math.max(cur.end, next.end);
            } else {
                result.add(cur);
                cur = next;
            }
        }
        result.add(cur);

        return result;
    }
}
