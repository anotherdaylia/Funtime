package com.lia.LinkedList;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * Created by liqu on 3/30/16.
 */
public class ReverseLinkedListII_92 {

    // assume 1 ≤ m ≤ n ≤ length of list
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, cur = head;
        int count = 1;

        // find m
        while(count < m) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        ListNode nodeBeforeM = prev;
        ListNode reversedTail = cur;

        // reverse linked list iteratively
        while (count <= n) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            count++;
        }

        ListNode reversedHead = prev;
        reversedTail.next = cur;
        if (m == 1) head = reversedHead;
        else nodeBeforeM.next = reversedHead;

        return head;
    }

    /*
     * Adding a pseudo head (or pseudo tail) can handle special case (head/tail case) as general case.
     */
    public ListNode reverseBetweenII(ListNode head, int m, int n) {
        ListNode pseudoHead = new ListNode(Integer.MIN_VALUE);
        pseudoHead.next = head;
        ListNode prev = null, cur = pseudoHead;
        int count = 0;

        // find m
        while(count < m) {
            prev = cur;
            cur = cur.next;
            count++;
        }

        ListNode nodeBeforeM = prev;
        ListNode reversedTail = cur;

        // reverse linked list iteratively
        while (count <= n) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
            count++;
        }

        ListNode reversedHead = prev;
        reversedTail.next = cur;
        nodeBeforeM.next = reversedHead;

        return pseudoHead.next;
    }
}
