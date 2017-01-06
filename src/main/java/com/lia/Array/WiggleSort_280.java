package com.lia.Array;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 *
 * Created by liqu on 1/5/17.
 */
public class WiggleSort_280 {
    /*
    If i is odd, then nums[i] >= nums[i - 1];
    If i is even, then nums[i] <= nums[i - 1].

    Time complexity is O(n).

    Explanation:
    suppose nums[0 .. i - 1] is wiggled, for position i:
    if i is odd, we already have, nums[i - 2] >= nums[i - 1],
    if nums[i - 1] <= nums[i], then we does not need to do anything, its already wiggled.
    if nums[i - 1] > nums[i], then we swap element at i -1 and i.
    Due to previous wiggled elements (nums[i - 2] >= nums[i - 1]),
    we know after swap the sequence is ensured to be nums[i - 2] > nums[i - 1] < nums[i], which is wiggled.
     */
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) { // even position
                if (i != 0 && nums[i - 1] < nums[i])
                    swap(nums, i - 1, i);
            } else { // odd position
                if (nums[i - 1] > nums[i])
                    swap(nums, i - 1, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
