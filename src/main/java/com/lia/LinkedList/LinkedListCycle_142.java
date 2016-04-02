package com.lia.LinkedList;

/**
 * Question: Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Created by liqu on 2/18/16.
 */
public class LinkedListCycle_142 {
    private boolean hasCycle;

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
    Define two pointers, slow moves one step at a time while fast moves two steps at a time.
    If they meet, there is a cycle on the list.

    Reset slow to head.
    Move both pointers one step at a time. They will meet at the beginning of the cycle.
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        hasCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        } else {
            return null;
        }
    }

    public static void main(String [ ] args) {
        LinkedListCycle_142 cycle = new LinkedListCycle_142();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = two;
        two.next = three;
        three.next = head;
        System.out.println(cycle.detectCycle(head).val);
    }
}
