package com.lia.LinkedList;

/**
 * Question: Given a linked list, determine if it has a cycle in it.
 *
 * Created by liqu on 2/18/16.
 */
public class LinkedListCycle_141 {

    private static class ListNode {
        private int val;
        private ListNode next;
        private ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /*
    Solution:
    Define two pointers, slow moves one step at a time, while fast moves two step at a time.

    If there is a cycle, they will eventually meet.
    Otherwise the fast pointer will run off the list first.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode s = head;
        ListNode f = head;

        while (s != null && f != null) {
            if (f.next == null) break;

            s = s.next;
            f = f.next.next;

            if (s == f)  return true;
        }

        return false;
    }

    public boolean hasCycleII(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String [ ] args) {
        LinkedListCycle_141 cycle = new LinkedListCycle_141();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = two;
        two.next = three;
        three.next = head;
        System.out.println(cycle.hasCycleII(head));
    }
}
