package com.lia.LinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and
 * O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The First node is considered odd, the second node even and so on ...
 *
 * Created by liqu on 3/29/16.
 */

public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode lastOdd = head;
        ListNode parent = head.next;
        ListNode cur = head.next.next;

        int count = 3;
        while (cur.next != null) {
            if (count % 2 != 0) {
                ListNode odd = new ListNode(cur.val);
                odd.next = cur.next;

                // delete cur node and advance cur pointer
                cur.val = cur.next.val;
                cur.next = cur.next.next;

                // insert odd as the next node of lastOdd
                odd.next = lastOdd.next;
                lastOdd.next = odd;

                lastOdd = odd;
                count++;

            } else{
                parent = cur;
                cur = cur.next;
                count++;
            }
        }

        // Note: Condition 'cur.next == null' is always 'true'
        //if (cur.next == null) {
            if (count % 2 != 0) {
                ListNode odd = new ListNode(cur.val);
                odd.next = cur.next;

                // delete cur node
                parent.next = null;

                // insert odd as the next node of lastOdd
                odd.next = lastOdd.next;
                lastOdd.next = odd;
            }
        //}

        return head;
    }
}
