package com.lia.StringTag;

/**
 * Implement strStr().
 * Returns the index of the First occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * RabinKarp with Hashing solution: http://algs4.cs.princeton.edu/53substring/RabinKarp.java.html
 * BoyerMoore(with skip): http://algs4.cs.princeton.edu/53substring/BoyerMoore.java.html
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

    // Brute Force solution: O(nm) runtime, O(1) space
    // http://algs4.cs.princeton.edu/53substring/Brute.java.html
    public int strStrBF(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j <= m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
            if (j == m) return i;
        }
        return -1;
    }

    public int strStrBF2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == m) return i - m;
        else return -1;
    }

    /*
    * This implementation uses the Boyer-Moore algorithm (with the bad-character
    * rule, but not the strong good suffix rule).
    * http://algs4.cs.princeton.edu/53substring/BoyerMoore.java.html
    */
    public int strStrBoyerMoore(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // position of rightmost occurrence of c in the pattern
        int[] radix = new int[256];
        for (int c = 0; c < radix.length; c++) radix[c] = -1;
        for (int j = 0; j < needle.length(); j++) radix[needle.charAt(j)] = j;

        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    skip = Math.max(1, j - radix[haystack.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;    // found
        }
        return -1; // not found
    }

}
