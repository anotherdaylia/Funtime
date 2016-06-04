package com.lia.Tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 *
 * Created by liqu on 5/31/16.
 */
public class BTUpsideDown_156 {

    //Iterative solution
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode p = root, parent = null, parentRight = null;
        while (p != null) {
            TreeNode left = p;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;

            parent = p;
            p = left;
        }
        return parent;
    }

    // bottom up DFS solution
    public TreeNode UpsideDownBTDFS(TreeNode root) {
        return convert(null, root);
    }

    private TreeNode convert(TreeNode parent, TreeNode node) {
        if (node == null) return parent;

        TreeNode root = convert(node.left, node);
        node.left = (parent == null) ?  parent : parent.right;
        node.right = parent;
        return root;
    }
}
