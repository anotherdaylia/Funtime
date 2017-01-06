package com.lia.Tree;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Created by liqu on 5/9/16.
 */
public class MaxDepthOfBTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = Integer.MIN_VALUE;
        int count = 1;
        return findDepth(root, depth, count);
    }

    private int findDepth(TreeNode node, int depth, int count) {
        if (node.left == null && node.right == null) {
            return Math.max(depth, count);
        }
        int depthLeft = 0;
        int depthRight = 0;
        if (node.left != null) depthLeft = findDepth(node.left, depth, count + 1);
        if (node.right != null) depthRight = findDepth(node.right, depth, count + 1);
        return Math.max(depthLeft, depthRight);
    }

    /* depth is the same as height, so as the calculation method
       11/11/16
     */
    public int mDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(mDepth(root.left), mDepth(root.right)) + 1;
    }
}
