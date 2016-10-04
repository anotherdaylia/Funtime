package com.lia.DP;

/**
 * After robbing those houses on that street, the thief has found himself a new place
 * for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * the security system for these houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Created by liqu on 7/11/16.
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        if (hi - lo < 1) return nums[lo];

        int v1 = 0, v2 = 0;
        v1 = nums[lo]; // best value at house 1
        v2 = Math.max(nums[lo], nums[lo + 1]); // best value at house 2

        for (int i = lo + 2; i <= hi; i++) {
            int tmp = v2;
            v2 = Math.max(v1 + nums[i], v2);
            v1 = tmp;
        }
        return v2;
    }
}
