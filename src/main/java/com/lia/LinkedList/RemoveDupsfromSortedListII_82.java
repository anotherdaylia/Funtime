package com.lia.LinkedList;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * Created by liqu on 3/31/16.
 */
public class RemoveDupsfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        boolean isDup = false;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                isDup = true;
            } else {
                if (isDup) {
                    // Case when the head is a dup
                    if (prev == null) {
                        cur = cur.next;
                        head = cur;
                    } else {
                        cur = cur.next;
                        prev.next = cur;
                    }
                    isDup = false;
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }
        }

        // Case when the last element is a dup, the next of cur is always null
        if (isDup) {
            if (prev == null) {
                //cur = cur.next;
                head = null;
            } else {
                //cur = cur.next;
                prev.next = null;
            }
        }
        return head;
    }
}
