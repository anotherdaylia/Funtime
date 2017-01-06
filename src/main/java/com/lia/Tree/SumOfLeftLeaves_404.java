package com.lia.Tree;

/**
 * Find the sum of all left leaves in a given binary tree.

 Example:
    3
   / \
  9  20
    /  \
   15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 * Created by liqu on 10/9/16.
 */
public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    private int sumOfLeftLeaves(TreeNode node, boolean isLeftChild) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) { // leaf node
            if (isLeftChild) return node.val;
            else return 0;
        } else {
            return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
        }
    }
}
