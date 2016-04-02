package com.lia.LinkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Created by liqu on 4/1/16.
 */
public class ReorderList_143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        int n = 0, half = 0;
        ListNode prev = head, cur = head;

        // find out the length of the list
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        // separate the list to two parts
        cur = head;
        while (half < n/2) {
            prev = cur;
            cur = cur.next;
            half++;
        }
        prev.next = null;

        // reverse the second half
        ListNode h2 = reverse(cur);
        ListNode h1 = head;

        // merge the two list into one
        while (h1 != null && h2 != null) {
            ListNode newh1 = h1.next;
            ListNode newh2 = h2.next;
            h1.next = h2;
            if (newh1 != null) h2.next = newh1;
            h1 = newh1;
            h2 = newh2;
        }
    }

    public ListNode reverse(ListNode head) {
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
