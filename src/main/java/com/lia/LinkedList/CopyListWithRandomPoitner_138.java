package com.lia.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * Created by liqu on 9/3/16.
 */
public class CopyListWithRandomPoitner_138 {
    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    /*
        My Solution with two maps.
        - the first map saves the <RandomListNode, index> mapping
        - the second map saves the <index, RandomListNode> mapping
        Create copy of nodes in one pass.
     */
    public RandomListNode copyRandomListLia(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, Integer> origMap = new HashMap<>();
        RandomListNode p = head;
        int index = 0;
        while (p != null) {
            origMap.put(p, index);
            p = p.next;
            index++;
        }

        RandomListNode[] copyMap = new RandomListNode[origMap.size()];
        p = head;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode node = newHead;
        while(node != null) {
            if (p.next == null) node.next = null;
            else {
                int next_index = origMap.get(p.next);
                if (copyMap[next_index] == null) {
                    copyMap[next_index] = new RandomListNode(p.next.label);
                }
                node.next = copyMap[next_index];
            }
            if (p.random == null) node.random = null;
            else {
                int rand_index = origMap.get(p.random);
                if (copyMap[rand_index] == null) {
                    copyMap[rand_index] = new RandomListNode(p.random.label);
                }
                node.random = copyMap[rand_index];
            }
            p = p.next;
            node = node.next;
        }
        return newHead;
    }

    /*
    Single map solution.
    In the first pass, copy the skeleton (next field) and put <orig node, copy of orig node> to map
    In the second pass, copy the random pointer by looking up the orig.random's mapping.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>(); //<orig Node, copy of orig node>
        RandomListNode orig = head;
        RandomListNode pseudo = new RandomListNode(0);
        RandomListNode copy = pseudo;

        // In one pass: copied the skeleton and saved map.
        while (orig != null) {
            copy.next = new RandomListNode(orig.label);
            map.put(orig, copy.next);
            orig = orig.next;
            copy = copy.next;
        }

        orig = head;
        copy = pseudo;
        while (orig != null) {
            copy.next.random = map.get(orig.random);
            orig = orig.next;
            copy = copy.next;
        }
        return pseudo.next;
    }
}
