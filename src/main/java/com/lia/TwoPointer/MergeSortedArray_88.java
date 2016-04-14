package com.lia.TwoPointer;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * Created by liqu on 4/7/16.
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // this referred to the merge sort algorithm
        int ix1 = 0, ix2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (ix1 >= m) { nums1[i] = nums2[ix2++];}
            else if (ix2 >= n) {nums1[i] = nums1_copy[ix1++];}
            else if (nums1_copy[ix1] <= nums2[ix2]) {
                nums1[i] =  nums1_copy[ix1++];
            } else {
                nums1[i] =  nums2[ix2++];
            }
        }
    }
}
