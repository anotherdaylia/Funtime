package com.lia.Tree;

/**
 * Invert Binary Tree
 *
 * Created by liqu on 5/9/16.
 */
public class InvertBinaryTree_226 {
    // created by liqu on 5/12
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    // coded on 10/7
    public TreeNode invertTreeII(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
