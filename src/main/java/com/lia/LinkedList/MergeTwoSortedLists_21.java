package com.lia.LinkedList;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Created by liqu on 3/29/16.
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null ) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        ListNode cur;

        if (l1.val <= l2.val) {
            head = l1;
            cur = l1;
            l1 = l1.next;
        } else {
            head = l2;
            cur = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head;
    }

    /*
     * Adding a pseudo head (or pseudo tail) can handle special case (head/tail case) as general case.
     */
    public ListNode mergeTwoListsII(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null ) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pseudoHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = pseudoHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return pseudoHead.next;
    }
}
