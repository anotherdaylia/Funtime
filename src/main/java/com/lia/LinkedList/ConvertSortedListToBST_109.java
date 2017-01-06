package com.lia.LinkedList;

import com.lia.Tree.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Created by liqu on 9/21/16.
 */
public class ConvertSortedListToBST_109 {
    /*
    This solution is better because it does not iterate to find mid point
    over and over again.
     */
    private ListNode listNode;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        listNode = head;
        return sortedListToBST(0, n - 1);
    }

    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + (hi - lo) / 2;
        TreeNode left = sortedListToBST(lo, mid - 1);
        TreeNode parent = new TreeNode(listNode.val);
        parent.left = left;
        listNode = listNode.next;
        parent.right = sortedListToBST(mid + 1, hi);

        return parent;
    }

    /*
    My solution - 1/3/2017
     */
    public TreeNode sortedListToBSTII(ListNode head) {
        int n = -1;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        return sortedListToBST(head, 0, n);
    }

    private TreeNode sortedListToBST(ListNode node, int lo, int hi) {
        //System.out.println(lo + ", " + hi);
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        int p = lo;
        ListNode midNode = node;
        while (p < mid) {
            p++;
            midNode = midNode.next;
        }
        TreeNode treeNode = new TreeNode(midNode.val);
        treeNode.left = sortedListToBST(node, lo, mid - 1);
        treeNode.right = sortedListToBST(midNode.next, mid + 1, hi);
        return treeNode;
    }
}
