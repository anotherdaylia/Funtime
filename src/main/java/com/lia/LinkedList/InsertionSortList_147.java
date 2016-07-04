package com.lia.LinkedList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Sort a linked list using insertion Sort.
 * Created by liqu on 6/8/16.
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        if (list.size() < 1) return null;
        Collections.sort(list);

        head = new ListNode(list.get(0));
        p = head;
        for(int i = 1; i < list.size(); i++) {
            p.next = new ListNode(list.get(i));
            p = p.next;
        }
        return head;
    }
}

