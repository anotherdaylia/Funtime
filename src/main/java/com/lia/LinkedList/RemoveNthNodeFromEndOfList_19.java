package com.lia.LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * Created by liqu on 4/5/16.
 */
public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pseudohead = new ListNode(Integer.MIN_VALUE);
        pseudohead.next = head;
        find(pseudohead, n);
        return pseudohead.next;
    }

    private int find(ListNode node, int n) {
        if(node.next == null) return 1;
        else {
            int count = find(node.next,n);
            if (count == n) {
                node.next = node.next.next;
            }
            return count + 1;
        }
    }
}
