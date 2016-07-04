package com.lia.Sort;

import java.util.*;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 * Created by liqu on 6/16/16.
 */
public class InsertInterval_57 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int N = intervals.size();
        int i = 0;
        // insert no overlapping intervals to result
        while (i < N && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i++));
        }

        // merge overlapping intervals to newInterval
        while (i < N && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        // add the new Interval to the result
        result.add(newInterval);

        // add all the rest
        while (i < N) result.add(intervals.get(i++));
        return result;
    }

    private int findPosition(List<Interval> intervals, int p) {
        int lo = 0, hi = intervals.size() - 1;

        if (intervals.size() < 1 || p < intervals.get(0).start) return 0;
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
        InsertInterval_57 insertion = new InsertInterval_57();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,9));


        insertion.insert(intervals, new Interval(0,10));

        // print
        for (int i = 0; i < intervals.size(); i++) {
            System.out.println("(" + intervals.get(i).start + ", " + intervals.get(i).end + ")");
        }
    }
}
