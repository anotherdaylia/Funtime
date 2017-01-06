package com.lia.DivideAndConquer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Created by liqu on 6/30/16.
 */
public class MergeKSortedLists_23 {

    /*
     Divide and Conquer solution
      */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pseudoHead = new ListNode(Integer.MIN_VALUE);
        ListNode cur = pseudoHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) { cur.next = l2;}
        if (l2 == null) { cur.next = l1;}

        return pseudoHead.next;
    }

    /*
     Min Heap solution:
     Each insertion operation into the PQ is log(k), there are nk elements
     Runtime O(nklogk), space O(k)
      */
    public ListNode mergeKListsHeap(ListNode[] lists) {
        if (lists.length < 1) return null;
        // create a priority queue to maintain k number of elements.
        // insertion time is log(k)
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(lists.length, listComparator);
        for (ListNode n : lists) { // initialize PQ with the smallest element of each list
            if (n != null) minPQ.offer(n);
        }

        ListNode pseudo = new ListNode(0);
        ListNode p = pseudo;
        while (minPQ.size() != 0) {
            // As we extract the nodes out from PQ, we insert its next not null node into the PQ
            ListNode node = minPQ.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                minPQ.offer(node.next);
            }
        }
        return pseudo.next;
    }

    private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
        }
    };
}
