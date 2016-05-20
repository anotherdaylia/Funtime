package com.lia.Tree;

/*
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 *
 * Created by liqu on 5/12/16.
 */
public class BalancedBT_110 {
    /*
     Recursive:
     1. base case
     2. normal case
     3. return value
     4. helper function (if have)
      */
    public boolean isBalanced(TreeNode root) {
        // This is the base case when a node has no child.
        if (root == null) return true;

        int lheight = height(root.left);
        int rheight = height(root.right);

        // Recommended by IntelliJ
//        if (Math.abs(lheight - rheight) > 1) {
//            return false;
//        } else {
//            return isBalanced(root.left) && isBalanced(root.right);
//        }
        return Math.abs(lheight - rheight) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    // This is the method to calculate the height of a tree rooted at the given node.
    private int height(TreeNode node) {
        // This is the base case when a node has no child.
        if (node == null) return 0;
        else return 1 + Math.max(height(node.left), height(node.right));
    }
}