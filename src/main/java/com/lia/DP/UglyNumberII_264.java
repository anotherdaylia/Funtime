package com.lia.DP;

import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.

 Hint:
 1. The naive approach is to call isUgly for every number until you reach the nth one.
 2. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 3. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 4. The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 5. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

 * Created by liqu on 9/26/16.
 */
public class UglyNumberII_264 {

    /*
    Priority Queue solution.
     */
    public int nthUglyNumberPQ(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> minPQ = new PriorityQueue<>();
        minPQ.add(1L);
        int count = 0;
        long ugly = -1;
        while (count < n) { // check boundary
            ugly = minPQ.poll();
            count++;
            for (int factor : factors) {
                long temp = ugly * factor;
                if (!minPQ.contains(temp)) {
                    minPQ.add(temp);
                }
            }
        }
        return (int)ugly;
    }

    /*
    DP solution
     */
    public int nthUglyNumberDP(int n) {
        if (n <= 0) return 0;

        int[] ugly = new int[n];
        ugly[0] = 1; // the 1st ugly number

        int a = 0, b = 0, c = 0; // index of three base candidate

        // make sure there are only three candidate to compare
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[a] * 2, Math.min(ugly[b] * 3, ugly[c] * 5));
            if (ugly[i] == ugly[a] * 2) a++;
            if (ugly[i] == ugly[b] * 3) b++;
            if (ugly[i] == ugly[c] * 5) c++;
        }
        return ugly[n - 1];
    }
}
