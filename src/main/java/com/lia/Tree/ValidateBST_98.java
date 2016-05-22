package com.lia.Tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 * Created by liqu on 5/21/16.
 */
public class ValidateBST_98 {
    public boolean isValidBST(TreeNode root) {
        boolean result = true;
        if (root == null) return result;

        if (root.left != null) {
            result &= maxValue(root.left) < root.val;
            result &= isValidBST(root.left);
        }

        if (root.right != null) {
            result &= minValue(root.right) > root.val;
            result &= isValidBST(root.right);
        }

        return result;
    }

    private int maxValue(TreeNode node) {
        while (node.right != null) node = node.right;
        return node.val;
    }

    private int minValue(TreeNode node) {
        while (node.left != null) node = node.left;
        return node.val;
    }
}
