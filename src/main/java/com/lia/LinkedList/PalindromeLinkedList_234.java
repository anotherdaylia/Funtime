package com.lia.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Created by liqu on 4/5/16.
 */
public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        //find out the length of the list
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        // find the second half and reverse the second half
        int mid = length / 2 + length % 2 + 1;
        reverseBetween(head, mid, length);

        ListNode half = head;
        int count = 1;
        while (count < mid) {
            half = half.next;
            count++;
        }

        cur = head;
        for (int i = mid; i <= length; i++) {
            if (cur.val != half.val) return false;
            else {
                cur = cur.next;
                half = half.next;
            }
        }
        return true;
    }

    private ListNode reverseBetween(ListNode head, int m, int n) {
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
