package com.lia.LinkedList;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * Created by liqu on 4/5/16.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode pseudohead = new ListNode(Integer.MIN_VALUE);
        pseudohead.next = head;

        ListNode preLarger = pseudohead;
        ListNode larger = pseudohead;

        // find the 1st node larger than x
        while (larger.next != null) {
            if (larger.val < x) {
                preLarger = larger;
                larger = larger.next;
            } else break;
        }

        if (larger.next != null){
            ListNode preSmaller = larger;
            ListNode smaller = larger;

            while (smaller.next != null) {
                if (smaller.val >= x) {
                    preSmaller = smaller;
                    smaller = smaller.next;
                } else { // found a smaller node
                    // insert the smaller node before the larger node
                    ListNode toBeInsert = new ListNode(smaller.val);
                    preLarger.next = toBeInsert;
                    toBeInsert.next = larger;
                    preLarger = preLarger.next;

                    //advance the smaller pointer
                    preSmaller.next = smaller.next;
                    smaller = smaller.next;
                }
            }

            // when the smaller is the last node
            if (smaller.val < x){
                ListNode toBeInsert = smaller;
                preLarger.next = smaller;
                smaller.next = larger;

                // remove the last node
                preSmaller.next = null;
            }
        }

        return pseudohead.next;
    }
}
