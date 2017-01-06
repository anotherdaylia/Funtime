package com.lia.Tree;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 * The path does not need to go through the root.
 *
 Example Questions Candidate Might Ask:
 Q: What if the tree is empty?
 A: Assume the tree is non-empty.
 Q: How about a tree that contains only a single node?
 A: Then the maximum path sum starts and ends at the same node.
 Q: What if every node contains negative value?
 A: Then you should return the single node value that is the least negative.
 Q: Does the maximum path have to go through the root node?
 A: Not necessarily. For example, the below tree yield 6 as the maximum path sum and does not go through root.
 *
 * Created by liqu on 9/21/16.
 */
public class BTMaxPathSum_124 {

    /*
    Anytime when you found that doing top down approach uses a lot of repeated calculation,
    bottom up approach usually is able to be more efficient.

    This is bottom up approach. At each node, the potential max path could be:
    i.  max(left subtree) + node
    ii. max(right subtree) + node
    iii. max(left subtree) + max(right subtree) + node
    iv. the node itself
     */
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findMaxSum(root);
        return max;
    }

    private int findMaxSum(TreeNode node) {
        if (node == null) return 0;

        // find the sum of one way path
        int lsum = findMaxSum(node.left);
        int rsum = findMaxSum(node.right);

        // update the max path if new path through current node is larger
        max = Math.max(lsum + rsum + node.val, max);

        // If sum is negative, return 0
        // - do not include this subtree as part of the parent node
        int sum = Math.max(lsum, rsum) + node.val;
        return sum > 0 ? sum : 0;
    }


    /*
    Solution2:
    A minor change at getPathSum() method, which I think make more sense.
     */
    private int maxSum;

    public int maxPathSumII(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        getPathSum(root);
        return maxSum;
    }

    /*
    if left or right is negative, then make it 0 -
    meaning do not include this subtree as part of the path
     */
    private int getPathSum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, getPathSum(node.left));
        int right = Math.max(0, getPathSum(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
