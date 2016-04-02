package com.lia.LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 * Created by liqu on 3/29/16.
 */
public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        //if (head == null) return null;
        ListNode prev = head, cur = head;

        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    cur = cur.next;
                    head = cur;
                } else {
                    prev.next = cur.next;
                    cur = prev.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
