package com.lia.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 - What if the given array is already sorted? How would you optimize your algorithm?
 - What if nums1's size is small compared to num2's size? Which algorithm is better?
 - What if elements of nums2 are stored on disk, and the memory is limited
 such that you cannot load all elements into the memory at once?

 * Created by liqu on 6/3/16.
 */
public class IntersectionOfTwoArraysII_350 {
    // Solution 1: O(N)
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> reslist = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); //<number, count>

        for (int n : nums1) {
            map.put(n, map.containsKey(n) ? map.get(n) + 1 : 1);
        }

        for (int n : nums2) {
            if (map.containsKey(n)) { // assume O(1)
                if (map.get(n) > 0) reslist.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        int[] result = new int[reslist.size()];
        for(int i = 0; i < reslist.size(); i++) result[i] = reslist.get(i);

        return result;
    }

    // Solution 2: Sorting: O(NlogN), Two pointer: O(N)
    // What if the given array is already sorted? How would you optimize your algorithm?
    public int[] intersectII(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums2[j]) i++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int n = 0; n < list.size(); n++) result[n] = list.get(n);
        return result;

    }
}
