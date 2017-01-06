package com.lia.Tree;

import java.util.LinkedList;

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
    /*
    This solution only works when the tree is a perfect binary tree.
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
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

    /*
    BFS solution - works for all binary tree, but use O(n) memory
    created on 11/11/16.
     */
    public void connectII(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode rightmost = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            if (node == rightmost) {
                if (queue.size() > 0) rightmost = queue.getLast();
            } else {
                node.next = queue.getFirst();
            }
        }
    }

    /*
    Other's solution - use O(1) memory but not for all binary tree
     */
    public void connectIII(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }
}

