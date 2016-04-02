package com.lia.LinkedList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Created by liqu on 4/2/16.
 */
public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int length = 0;
        // counting the length of the list
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int round = length / k;
        int m = 0, n= 0, r = 0;

        // do the 1st round
        if (round > 0) {
            r = 1;
            head = reverseBetween(head, 1, k);
            m = k + 1;
            n = m + k - 1;
        }

        while (r < round) {
            r++;
            reverseBetween(head, m, n);
            m = n + 1;
            n = m + k - 1;
        }

        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, cur = head;
        ListNode last, t, h;
        int count = 1;

        while(count < m) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        last = prev;
        t = cur;

        while (count <= n) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            count++;
        }

        h = prev;
        t.next = cur;
        if (m == 1) head = h;
        else last.next = h;

        return head;
    }
}
