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
    Otherwise the fast pointer will run off the list First.
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr)  return true;
        }

        return false;
    }

    public boolean hasCycleII(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            //slowPtr = slowPtr.next;
            //fastPtr = fastPtr.next.next;

            slowPtr = move(slowPtr, 1);
            fastPtr = move(fastPtr, 2);

            if (slowPtr == fastPtr) return true;
        }

        return false;
    }

    // Add this funtction to make the pointer change more readable
    private ListNode move(ListNode node, int steps) {
        int count = 0;
        while (count < steps){
            node = node.next;
            count++;
        }
        return node;
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
