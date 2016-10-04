package com.lia.DP;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 * Created by liqu on 9/24/16.
 */
public class DecodeWays_91 {
    /*
    '0' is only valid when the number before 0 is 1 or 2, otherwise the input is an invalid decode and return 0
     */
    public int numDecodingsCache(String s) {
        char[] c = s.toCharArray();
        if (c.length == 0 || c[0] == '0') return 0;

        int[] N = new int[c.length + 1];
        N[0] = 1; // helper
        N[1] = 1; // the first number

        for (int i = 2; i <= c.length; i++) {
            // 0 cannot be used separately, so change N[i-1] to 0.
            if (c[i - 1] == '0') N[i - 1] = 0;

            N[i] += N[i - 1];
            if (c[i - 2] == '1' || c[i - 2] == '2' && c[i - 1] <= '6') {
                N[i] += N[i - 2];
            }
        }

        return N[c.length];
    }

    /*
    eliminate cache and use two variables instead
     */
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        if (c.length == 0 || c[0] == '0') return 0;

        int prev2 = 1; // helper
        int prev1 = 1; // the first number
        int count = prev1;
        for (int i = 2; i <= c.length; i++) {
            if (c[i - 1] == '0') prev1 = 0;

            count = prev1;
            if (c[i - 2] == '1' || c[i - 2] == '2' && c[i - 1] <= '6') {
                count += prev2;
            }
            prev2 = prev1;
            prev1 = count;
        }

        return count;
    }

}
