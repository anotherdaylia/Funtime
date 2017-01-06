package com.lia.BinarySearch;

import java.util.Arrays;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * Hint: Expected runtime complexity is in O(log n) and the input is sorted.
 *
 * Created by liqu on 6/7/16.
 */
public class HIndexII_275 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int count = 0;

        for(int i = citations.length - 1; i >= 0; i--) {
            count++;
            if (citations[i] < count) {
                return count - 1;
            }
        }

        return count;
    }

    /*
    12.25.2016
    The basic idea of this solution is to use binary search to find the minimum index such that
    citations[index] >= length(citations) - index
    After finding this index, the answer is length(citations) - index.

    case 1: citations[mid] == len-mid, there are citations[mid] papers that have at least citations[mid] citations.
    case 2: citations[mid] > len-mid, there are citations[mid] papers that have more than citations[mid] citations.
    case 3: citations[mid] < len-mid, we should continue searching in the right side
     */
    public int hIndex_binarySearch(int[] citations) {
        int n = citations.length;
        int h = 0;

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] < n - mid) {
                lo = mid + 1;
            } else if (citations[mid] > n - mid) {
                hi = mid - 1;
            } else return n - mid;

        }

        return n - lo;
    }
}
