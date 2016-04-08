package com.lia.TwoPointer;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * Created by liqu on 4/5/16.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxarea = Integer.MIN_VALUE;

        while(lo < hi){
            int lomax = height[lo];
            int himax = height[hi];
            int candidate = Math.min(height[lo],height[hi])*(hi - lo);
            maxarea = Math.max(maxarea, candidate);

            if(height[lo] < height[hi]) {
                while(lo < hi && height[lo] <= lomax) lo++;
            } else {
                while(lo < hi && height[hi] <= himax) hi--;
            }
        }

        return maxarea;
    }
}
