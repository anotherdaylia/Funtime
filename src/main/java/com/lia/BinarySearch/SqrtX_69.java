package com.lia.BinarySearch;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 * Created by liqu on 6/8/16.
 */
public class SqrtX_69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;

        int lo = 1, hi = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (x / mid < mid) { //x < mid * mid
                hi = mid - 1;
            } else if (x / mid > mid) { //x < mid * mid
                if (x / (mid + 1) < (mid + 1)) return mid;
                else lo = mid + 1;
            } else return mid;
        }

        return -1;
    }
}
