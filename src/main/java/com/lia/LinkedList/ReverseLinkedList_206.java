package com.lia.LinkedList;

/**
 * Reverse a singly linked list.
 *
 * Created by liqu on 3/25/16.
 */
public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        return reverse(head, head.next);
    }

    /**
     * Time complexity O(n)
     * Space complexity O(n):
     * The extra space comes from implicit stack space due to recursion.
     * The recursion could go up to n levels deep
     */

    // recursive version 1
    private ListNode reverse (ListNode a, ListNode b) {
        if (b.next != null) {
            ListNode newHead = reverse (b, b.next);
            b.next = a;
            a.next = null;
            return newHead;
        } else {
            b.next = a;
            a.next = null;
            return b;
        }
    }

    // recursive version 2
    private ListNode reverse2 (ListNode a, ListNode b) {
        ListNode newHead;
        if (b.next != null) {
            newHead = reverse (b, b.next);
        } else {
            newHead = b;
        }

        b.next = a;
        a.next = null;
        return newHead;
    }

    // Iterative version
    public ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
