package com.lia.Tree;

/**
 * Given a binary tree and a sum, determine
 * if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 * [5,4,8,11,null,13,4,7,null,null,2,null,1]
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * Created by liqu on 5/18/16.
 */
public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // base case
        if (root == null) return false;

        // if root is a leaf
        if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
        }
    }
}
