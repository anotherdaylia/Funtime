package com.lia.DP;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * Created by liqu on 8/23/16.
 */
public class PerfectSquare_279 {
    // DP solution
    public int numSquares(int n) {
        int[] numSqrs = new int[n + 1];
        for (int i = 0; i <=n ; i++) numSqrs[i] = Integer.MAX_VALUE;
        numSqrs[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                numSqrs[i] = Math.min(numSqrs[i], numSqrs[i - j*j] + 1);
            }
        }
        return numSqrs[n];
    }
}

