package com.lia.DP;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from
 * robbing each of them is that adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Created by liqu on 7/11/16.
 */
public class HouseRobber_198 {

    // Solution with O(n) space
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        int[] value = new int[nums.length];
        value[0] = nums[0]; // best value at house 1
        value[1] = Math.max(nums[0], nums[1]); // best value at house 2

        for (int i = 2; i < nums.length; i++) {
            value[i] = Math.max(value[i-2] + nums[i], value[i-1]);
        }
        return value[nums.length - 1];
    }

    // Solution with O(1) space
    public int rob2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];

        int v1 = 0, v2 = 0;
        v1 = nums[0]; // best value at house 1
        v2 = Math.max(nums[0], nums[1]); // best value at house 2

        for (int i = 2; i < nums.length; i++) {
            int tmp = v2;
            v2 = Math.max(v1 + nums[i], v2);
            v1 = tmp;
        }
        return v2;
    }
}
