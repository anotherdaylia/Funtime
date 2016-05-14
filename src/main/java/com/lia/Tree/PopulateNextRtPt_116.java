package com.lia.Tree;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 * and every parent has two children).
 *
 * Created by liqu on 5/12/16.
 */
public class PopulateNextRtPt_116 {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            connect(root.left);
            connect(root.right);
            connectNode(root.left, root.right);
        }
    }

    private void connectNode(TreeLinkNode left, TreeLinkNode right) {
        if(left.right != null && right.left != null) {
            left.right.next = right.left;
            connectNode(left.right, right.left);
        }
    }
}

