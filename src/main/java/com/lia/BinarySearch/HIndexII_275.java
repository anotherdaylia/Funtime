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
}
