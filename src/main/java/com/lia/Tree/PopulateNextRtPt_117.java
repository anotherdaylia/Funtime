package com.lia.Tree;

import java.util.LinkedList;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 *
 * Created by liqu on 11/11/16.
 */
public class PopulateNextRtPt_117 {

    /*
    Other's solution. The idea is level order traversal.
     */
    public void connectConstant(TreeLinkNode root) {
        TreeLinkNode dummyHead = new TreeLinkNode(0);
        TreeLinkNode prev = dummyHead;
        while (root != null) {
            if (root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if (root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;

            // prepare for a new level
            if (root == null) {
                root = dummyHead.next;
                dummyHead.next = null;
                prev = dummyHead;
            }
        }
    }

    /*
    My solution but not using constant space
     */
    public void connect(TreeLinkNode root) {
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
}
