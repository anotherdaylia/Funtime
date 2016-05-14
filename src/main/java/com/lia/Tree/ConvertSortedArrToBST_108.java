package com.lia.Tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Created by liqu on 5/11/16.
 */
public class ConvertSortedArrToBST_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length < 1) return null;

        int lo = 0, hi = nums.length - 1;
        return findNext(nums, lo, hi);
    }

    private TreeNode findNext(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (lo <= mid - 1) {
            node.left = findNext(nums, lo, mid - 1);
        }
        if (mid + 1 <= hi) {
            node.right = findNext(nums, mid + 1, hi);
        }
        return node;
    }
}
