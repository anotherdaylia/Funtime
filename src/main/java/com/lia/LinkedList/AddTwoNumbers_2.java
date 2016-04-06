package com.lia.LinkedList;

/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Created by liqu on 4/5/16.
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create a dummyhead for the new list
        ListNode dummyhead = new ListNode(0);
        ListNode cur = dummyhead;

        ListNode h1 = l1, h2 = l2;
        int carry = 0;
        while(h1 != null || h2 != null) {
            // because h1 or h1 might be null and generate NullPointerException
            // we need to use x, y to save the values.
            int x = (h1 != null) ? h1.val : 0;
            int y = (h2 != null) ? h2.val : 0;

            // we don't need sum value outside the block, so created a local variable
            int sum = x + y + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }

        // creat and append the last node if carryover is 1
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return dummyhead.next;
    }

    public ListNode addTwoNumbersSlow(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l2 == null) return l1;
        else if (l1 == null) return l2;

        ListNode h1 = l1, h2 = l2;
        ListNode preh1 = h1, preh2 = h2;
        int sum = 0;
        int carryover = 0;
        while(h1 != null && h2 != null) {
            sum = h1.val + h2.val + carryover;
            h1.val = sum % 10;
            carryover = sum / 10;

            preh1 = h1;
            preh2 = h2;
            h1 = h1.next;
            h2 = h2.next;
        }

        if (h2 == null) {
            addNumbers(h1, preh1, sum, carryover);
        } else {
            preh1.next = h2;
            preh2.next = null;
            addNumbers(preh1.next, preh1, sum, carryover);
        }

        return l1;
    }

    private void addNumbers(ListNode h1, ListNode preh1, int sum, int carryover){
        while (h1 != null) {
            sum = h1.val + carryover;
            h1.val = sum % 10;
            carryover = sum / 10;

            //System.out.println ("h1: " + h1.val);
            preh1 = h1;
            h1 = h1.next;
        }

        if (carryover > 0) {
            ListNode lastnode = new ListNode(carryover);
            preh1.next = lastnode;
        }
    }
}
