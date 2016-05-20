package com.lia.Tree;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * Created by liqu on 5/19/16.
 */
public class FlattenBTtoLinkedList_114 {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;

        if (node.left != null && node.right != null) {
            TreeNode flatLeft = flattenTree(node.left);
            TreeNode flatRight = flattenTree(node.right);
            node.right = flatLeft;
            node.left = null;

            TreeNode temp = node;
            while (temp.right != null) temp = temp.right;
            temp.right = flatRight;

        } else if (node.right != null) {
            node.right = flattenTree(node.right);
        } else if (node.left != null) {
            node.right = flattenTree(node.left);
            node.left = null;
        }

        return node;
    }
}
