package com.lia.DP;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 * Created by liqu on 9/29/16.
 */
public class DistinctSubsequences_115 {

    public int numDistinct(String s, String t) {
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        if (sc.length < tc.length) return 0;

        int[][] N = new int[tc.length + 1][sc.length + 1];

        // A helper row if t is an empty string:
        // the empty string is a subsequence of any string but only 1 time
        for (int j = 0; j < sc.length; j++) {
            N[0][j] = 1;
        }

        for (int i = 1; i <= tc.length; i++) {
            // j < i is not valid, otherwise there aren't enough char in t to seat before s[j]
            for (int j = i; j <= sc.length; j++){
                if (tc[i - 1] == sc[j - 1]) {
                    // the # of subsequence the prev char had + the # of chars for current row
                    N[i][j] += N[i - 1][j - 1] + N[i][j - 1];
                } else N[i][j] = N[i][j - 1];
            }
        }

        return N[tc.length][sc.length];
    }
}
