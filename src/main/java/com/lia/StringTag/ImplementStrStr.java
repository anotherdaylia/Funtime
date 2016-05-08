package com.lia.StringTag;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Created by liqu on 5/7/16.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {

        int lo = 0, hi = needle.length() - 1;
        while (hi < haystack.length()){
            if (haystack.substring(lo, hi + 1).equals(needle)){
                return lo;
            } else {
                lo++;
                hi++;
            }
        }
        return -1;
    }
}
