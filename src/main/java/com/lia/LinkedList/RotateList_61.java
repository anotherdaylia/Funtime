package com.lia.LinkedList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * Created by liqu on 4/5/16.
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        //find out the length of the list
        int length = 0;
        ListNode cur = head, pre = head;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        // find the Kth position
        ListNode knode = head;
        ListNode preK = head;
        int count = 1;
        while (count <= length - k) {
            preK = knode;
            knode = knode.next;
            count++;
        }

        preK.next = null;
        pre.next = head;
        head = knode;
        return head;
    }
}
