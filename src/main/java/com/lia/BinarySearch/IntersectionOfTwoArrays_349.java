package com.lia.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.

 * Created by liqu on 6/3/16.
 */
public class IntersectionOfTwoArrays_349 {
    // Solution 1
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);

        for (int i : nums2) {
            if (Arrays.binarySearch(nums1, i) >= 0) {
                if(!set.contains(i)) set.add(i);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for(int n : set) result[i++] = n;

        return result;
    }
}
