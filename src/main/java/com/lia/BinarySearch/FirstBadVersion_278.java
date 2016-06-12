package com.lia.BinarySearch;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Created by liqu on 6/5/16.
 */
public class FirstBadVersion_278 {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int mid;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1) {
                    return mid;
                } else {
                    if (!isBadVersion(mid - 1)) return mid;
                    else hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isBadVersion(int n) {
        return true;
    }

    public int firstBadVersionII(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
