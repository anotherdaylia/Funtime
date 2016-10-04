package com.lia.DP;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Created by liqu on 7/14/16.
 */
public class ClimbingStairs_70 {
    // Solution 1: space O(1)
    public int climbStairsTwoVars(int n) {
        if(n <= 1) return 1;

        int num = 0;
        int oneStep = 1;
        int twoStep = 1;
        for(int i = 2; i <= n; i++) {
            num = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = num;
        }

        return num;
    }

    // Solution 2: space O(n)
    public int climbStairs(int n) {
        int[] cache = new int[n + 1]; //cache[x][0] is climb, cache[x][1] is not climb

        cache[0] = 1;
        cache[1] = 1;
        for(int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }
}
