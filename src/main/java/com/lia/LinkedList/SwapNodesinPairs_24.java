package com.lia.LinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 * Created by liqu on 4/5/16.
 */

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode last = head.next;

        // Note: Condition 'prev != null' is always 'true'
        // We checked when head == null, and in every movement we guaranteed that cur != null
        // while (prev != null && cur !- null) {
        while(cur != null) {
            if (prev == head) {
                prev.next = cur.next;
                cur.next = prev;
                head = cur;
            } else {
                prev.next = cur.next;
                last.next = cur;
                cur.next = prev;
            }
            last = prev;
            prev = prev.next;
            if (prev == null) break;
            else cur = prev.next;
        }

        return head;
    }
}
