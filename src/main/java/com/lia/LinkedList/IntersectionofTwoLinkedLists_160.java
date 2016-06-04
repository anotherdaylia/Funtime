package com.lia.LinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
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
public class IntersectionofTwoLinkedLists_160 {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA, curB = headB;
            int lengthA = 0, lengthB = 0;

            // 1. find out the length of list A
            while (curA != null) {
                curA = curA.next;
                lengthA++;
            }

            // 2. find out the length of list B
            while (curB != null) {
                curB = curB.next;
                lengthB++;
            }

            // 3. make list A and list B with the same remaining length
            curA = headA;
            curB = headB;
            int step = lengthA - lengthB;
            if (step > 0) { // list A is longer than list B
                for (int i = 0; i < step; i++) curA = curA.next;
            } else { // list B is longer than list A
                for (int i = 0; i < Math.abs(step); i++) curB = curB.next;
            }

            // 4. The First node share the same value is the intersect
            while (curA != null && curB != null && curA.val != curB.val) {
                curA = curA.next;
                curB = curB.next;
            }

            return curA;
        }

}
